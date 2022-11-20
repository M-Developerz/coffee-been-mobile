//
//  CapturePasswordScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import CommonDomain
import UIPilot

struct PasswordScreenView: View {
    @EnvironmentObject var pilot: UIPilot<AppRoute>
    @ObservedObject var viewModel = PasswordScreenViewModel()
        
    @State private var password: String = ""
    @State private var confirmPassword: String = ""
    @State private var isStartNavigationLinkActive = false
    @State private var hasNetworkError: Bool = false
    
    let firstName: String
    let lastName: String
    let email: String
    let username: String

    
    private func handleCreateUserAction() {
        let user =  UserModel(
            firstName: firstName,
            lastName: lastName,
            username: username,
            email: email,
            id: nil,
            password: password
        )
        viewModel.createUserAccount(user: user)
    }
    
    private func onViewStateChange() {
        if viewModel.isOperationSuccess {
            pilot.popTo(.start)
        }
        
        hasNetworkError = viewModel.isOperationError
    }

    var body: some View {
        VStack {
            RegistrationHeaderView(
                    headerTitle: "Input Your Password"
            )

            PasswordTextInputField(
                    value: $password,
                    label: "Password",
                    placeHolder: ""
            )

            PasswordTextInputField(
                    value: $confirmPassword,
                    label: "Confirm Password",
                    placeHolder: ""
            ).padding(.top, 20)

            Spacer()
            
            Text("Unknown Error")
                .opacity(hasNetworkError ? 1 : 0)
            
            Button(action: handleCreateUserAction) {
                HStack(alignment: .center) {
                    Text("Create Password")
                            .foregroundColor(.white)
                            .font(.headline)
                }.frame(maxWidth: .infinity)
                    .padding(.vertical, 15)
                    .background(Color.green)
                    .cornerRadius(15)
                
            }.padding(.bottom, 50)
                .padding(.top, 100)
                .onAppear {
                    viewModel.onViewStateChanged = onViewStateChange
                }

        }
                .padding(.horizontal, 20)
    }
}

struct PasswordScreenView_Previews: PreviewProvider {
    static var previews: some View {
        
        PasswordScreenView(
            firstName: "",
            lastName: "",
            email: "",
            username: ""
        )
    }
}
