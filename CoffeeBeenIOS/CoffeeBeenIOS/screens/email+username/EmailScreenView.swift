//
//  CaptureEmailAndPassword.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct EmailScreenView: View {
    @ObservedObject var viewModel = EmailScreenViewModel()
    
    @State private var username: String = ""
    @State private var email: String = ""
    
    private func handleSubmitUsernameAndEmail() {
        if username.isEmpty && email.isEmpty {
            print("Invalid Email and Password")
            return
        }
        let user = UserValidationModel(username: username, email: email)
        viewModel.validateUser(user: user)
    }
    
    var isEmailAndUsernameValid: Bool {
        return viewModel.validationResult?.isSuccess ?? false
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
            
            Text("Email And Password Are Valid")
                .modifier(HiddenIfModifier(condition: !isEmailAndUsernameValid))
            
            Button(action: handleSubmitUsernameAndEmail) {
                HStack (alignment: .center) {
                    Text("Create Account")
                        .foregroundColor(.white)
                        .font(.headline)
                }.frame(maxWidth: .infinity)
                    .padding(.vertical, 15)
                    .background(Color.green)
                    .cornerRadius(15)
            }.padding(.bottom, 50)
                .padding(.top, 100)
            
        }.padding(.horizontal, 20)
    }
}

struct CaptureEmailAndPassword_Previews: PreviewProvider {
    static var previews: some View {
        EmailScreenView()
    }
}
