//
//  CapturePasswordScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import CommonDomain

struct PasswordScreenViewArguments {
    let firstName: String
    let lastName: String
    let email: String
    let username: String
}

struct PasswordScreenView: View {
    @ObservedObject var viewModel = PasswordScreenViewModel()
    
    let arguments: PasswordScreenViewArguments
    
    @State private var password: String = ""
    @State private var confirmPassword: String = ""
    @State private var isStartNavigationLinkActive = false
    
    func handleCreateUserAction() {
        let user =  UserModel(
            firstName: arguments.firstName,
            lastName: arguments.lastName,
            username: arguments.username,
            email: arguments.email,
            id: nil,
            password: password
        )
        viewModel.createUserAccount(user: user)
    }
    
    func onViewStateChange() {
        isStartNavigationLinkActive = viewModel.isCreateAccountSuccess
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
            
            NavigationLink("", destination: StartScreenView(), isActive: $isStartNavigationLinkActive)

        }
                .padding(.horizontal, 20)
                .onAppear {
                    onViewStateChange()
                }
    }
}

struct PasswordScreenView_Previews: PreviewProvider {
    
    static let arguments = PasswordScreenViewArguments(
        firstName: "",
        lastName: "",
        email: "",
        username: ""
    )
    static var previews: some View {
        PasswordScreenView(arguments: arguments)
    }
}
