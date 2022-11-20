//
//  CaptureEmailAndPassword.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import UIPilot

struct EmailScreenView: View {
    @EnvironmentObject var pilot: UIPilot<AppRoute>
    @ObservedObject var viewModel = EmailScreenViewModel()

    @State private var username: String = ""
    @State private var usernameError: String? = nil
    @State private var email: String = ""
    @State private var emailError: String? = nil
    @State private var hasNetworkErroe: Bool = false
    
    let firstName: String
    let lastName: String

    private func handleSubmitUsernameAndEmail() {
        usernameError = username.isEmpty ? nil : "Required"
        emailError = email.isEmpty ? nil : "Required"
        
        if !username.isEmpty && !email.isEmpty {
            let user = UserValidationModel(
                username: username,
                email: email
            )
            
            viewModel.validateUser(user: user)
        }
    }
    
    private func onUsernameAndEmailValid() {
        if viewModel.isDataValid {
            pilot.push(.password(firstName: firstName, lastName: lastName, email: email, username: username))
        }
        
        hasNetworkErroe = !viewModel.isDataValid
    }


    var body: some View {
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
                .onAppear {
                    viewModel.onViewStateChanged = onUsernameAndEmailValid
                }
                
                
            }
            .padding(.horizontal, 20)
    }
}

struct CaptureEmailAndPassword_Previews: PreviewProvider {
    static var previews: some View {
        EmailScreenView(
            firstName: "",
            lastName: ""
        )
    }
}
