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
    let error: Error?
    let userModel: UserModel?
}

class PasswordScreenViewModel: BaseViewModel<PasswordScreenViewState> {
    
    init() {
        super.init(initialState: PasswordScreenViewState(
            loadingState: .idle,
            error: nil,
            userModel: nil
        ))
    }
    
    override init(initialState: PasswordScreenViewState) {
        fatalError("This constructor not implemented")
    }
    
    func createUserAccount(user: UserModel) {
        updateState { prevState in
            PasswordScreenViewState(
                loadingState: .idle,
                error: prevState.error,
                userModel: prevState.userModel
            )
        }
        
        executeUseCase(
            input: user,
            usecase: DomainModule.shared.createUserAccountUseCase,
            onResult: { [weak self] result in
                self?.updateState { prevState in
                    PasswordScreenViewState(
                        loadingState: .success,
                        error: prevState.error,
                        userModel: prevState.userModel
                    )
                }
            },
            onError: {[weak self] error in
                self?.updateState { prevState in
                    PasswordScreenViewState(
                        loadingState: .error,
                        error: error,
                        userModel: prevState.userModel
                    )
                }
            }
        )
    }
}

extension PasswordScreenViewModel {
    var isOperationSuccess: Bool {
        return viewState.loadingState == .success && viewState.error == nil
    }
    
    var isOperationError: Bool {
        return viewState.loadingState == .error && viewState.error != nil
    }
}
