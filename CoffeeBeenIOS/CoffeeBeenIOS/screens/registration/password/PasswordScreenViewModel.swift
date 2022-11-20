//
//  PasswordScreenViewModel.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 20/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import CommonDomain

struct PasswordScreenViewState: ViewState {
    let loadingState: LoadingState
}

class PasswordScreenViewModel: BaseViewModel<PasswordScreenViewState> {
    
    init() {
        super.init(initialState: PasswordScreenViewState(loadingState: .idle))
    }
    
    override init(initialState: PasswordScreenViewState) {
        fatalError("This constructor not implemented")
    }
    
    func createUserAccount(user: UserModel) {
        updateState { prevState in
            PasswordScreenViewState(loadingState: .idle)
        }
        
        executeUseCase(
            input: user,
            usecase: DomainModule.shared.createUserAccountUseCase,
            onResult: { [weak self] result in
                self?.updateState { prevState in
                    PasswordScreenViewState(
                        loadingState: .success
                    )
                }
            },
            onError: {[weak self] error in
                self?.updateState { prevState in
                    PasswordScreenViewState(loadingState: .error)
                }
            }
        )
    }
}

extension PasswordScreenViewModel {
    var isCreateAccountSuccess: Bool {
        return viewState.loadingState == .success
    }
}
