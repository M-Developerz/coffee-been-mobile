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

class EmailScreenViewModel: ObservableObject {
    @Published var validationResult: UserValidationResult? = nil
    
    func validateUser(user: UserValidationModel) {
        CommonDomainModule.shared.validateUserUseCase.execute(request: user) { result, error in
            guard let result = result else {
                
                if let error = error {
                    print("Error occurred \(error.localizedDescription)")
                }
                
                return
            }
            
            DispatchQueue.main.async {
                self.validationResult = result
            }
        }
    }
}
