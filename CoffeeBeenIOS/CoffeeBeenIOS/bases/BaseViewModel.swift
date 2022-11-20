//
//  BaseViewModel.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 20/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import Combine
import SwiftUI

protocol ViewState {}

class BaseViewModel<VIEW_STATE: ViewState>: ObservableObject {
    var onViewStateChanged: (() -> Void)? = nil
    
    @Published var viewState: VIEW_STATE {
        didSet {
            onViewStateChanged?()
        }
    }
    
    init(initialState: VIEW_STATE) {
        self.viewState = initialState
    }
    
    func updateState(updator: (VIEW_STATE) -> VIEW_STATE) {
        viewState = updator(viewState)
    }
    
    func executeUseCase<INPUT, RESPONSE>(
        input: INPUT,
        usecase: BaseUseCase<INPUT, RESPONSE>,
        onResult: @escaping (RESPONSE) -> Void,
        onError: @escaping (Error) -> Void
        
    ) {
        usecase.execute(request: input) { result, error in
            if error != nil {
                DispatchQueue.main.async {
                    onError(error!)
                }
                return
            }
            
            guard let result = result else { return }
            
            DispatchQueue.main.async {
                onResult(result)
            }
            
        }
        
    }
}
