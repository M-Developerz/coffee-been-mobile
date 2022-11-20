//
//  EmailScreenViewModel.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import CommonDomain

struct EmailScreenViewState: ViewState {
    let data: UserValidationResult?
    let loadingState: LoadingState
}

class EmailScreenViewModel: BaseViewModel<EmailScreenViewState> {
    
    init() {
        super.init(initialState: EmailScreenViewState(
            data: nil, loadingState: .idle))
    }
    
    override init(initialState: EmailScreenViewState) {
        fatalError("Not Implemented Use The Default Instead")
    }

    func validateUser(user: UserValidationModel) {
        updateState { prevState in
            EmailScreenViewState(data: prevState.data, loadingState: .loading)
        }
        
        executeUseCase(
            input: user,
            usecase: DomainModule.shared.validateUserUseCase,
            onResult: { [weak self] response in
                self?.updateState { previousState in
                    EmailScreenViewState(data: response, loadingState: .success)
                }
            },
            onError: { [weak self] error in
                self?.updateState { prevState in
                    EmailScreenViewState(data: prevState.data, loadingState: .error)
                }
            })
    }
}


extension EmailScreenViewModel {
    var isloading: Bool {
        return viewState.loadingState == .loading
    }
    
    var isDataValid: Bool {
        return viewState.loadingState == .success && viewState.data != nil
    }
}
