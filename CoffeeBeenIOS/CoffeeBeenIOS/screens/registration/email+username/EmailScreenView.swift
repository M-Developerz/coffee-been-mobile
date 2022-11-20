//
//  CaptureEmailAndPassword.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct EmailScreeViewArguments {
    let firstName: String
    let lastName: String
}


struct EmailScreenView: View {
    @ObservedObject var viewModel = EmailScreenViewModel()

    @State private var username: String = ""
    @State private var email: String = ""
    @State private var isPasswordLinkActive = false
    
    let arguments: EmailScreeViewArguments

    private func handleSubmitUsernameAndEmail() {
        if username.isEmpty && email.isEmpty {
            print("Invalid Email and Password")
            return
        }
        let user = UserValidationModel(username: username, email: email)
        viewModel.validateUser(user: user)
    }
    
    private func onViewStateChanged() {
        isPasswordLinkActive = viewModel.isDataValid
    }
    
    var passwordScreenArgs: PasswordScreenViewArguments {
        PasswordScreenViewArguments(
            firstName: arguments.firstName,
            lastName: arguments.lastName,
            email: email,
            username: username
        )
    }


    var body: some View {
        NavigationView {
            VStack {
                RegistrationHeaderView(
                    headerTitle: "Input Your Account"
                )
                
                TextInputField(
                    value: $username,
                    label: "User Name",
                    placeHolder: "johndoe"
                )
                
                TextInputField(
                    value: $email,
                    label: "Email Address",
                    placeHolder: "someone@gmail.com"
                ).padding(.top, 20)
                
                Spacer()
                
                if viewModel.isloading {
                    Text("Loading..")
                }
                
                
                Button(action: handleSubmitUsernameAndEmail) {
                    HStack(alignment: .center) {
                        Text("Create Account")
                            .foregroundColor(.white)
                            .font(.headline)
                    }
                    .frame(maxWidth: .infinity)
                    .padding(.vertical, 15)
                    .background(Color.green)
                    .cornerRadius(15)
                }
                .padding(.bottom, 50)
                .padding(.top, 15)
                
                // Navigation
                NavigationLink("", destination: PasswordScreenView(arguments: passwordScreenArgs),
                               isActive: $isPasswordLinkActive)
                
                
            }
            .padding(.horizontal, 20)
            
        }.onAppear {
            viewModel.onViewStateChanged = onViewStateChanged
        }
    }
}

struct CaptureEmailAndPassword_Previews: PreviewProvider {
    static var previews: some View {
        EmailScreenView(
            arguments:EmailScreeViewArguments(
                firstName: "",
                lastName: ""
            )
        )
    }
}
