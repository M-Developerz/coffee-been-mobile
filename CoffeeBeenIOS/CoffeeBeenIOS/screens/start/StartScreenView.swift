//
//  StartScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 20/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct StartScreenView: View {
    @State private var username: String = ""
    @State private var password: String = ""
    @State private var isNameScreenLinkActive = false
    
    func handleCreateUserAction() {
        isNameScreenLinkActive.toggle()
    }

    var body: some View {
        VStack {
            HStack(alignment: .center) {
                Text("Coffee")
                        .font(.system(size: 30, weight: .bold))
                        .foregroundColor(.black)

                Text("Coffee")
                        .padding(.leading, -8)
                        .font(.system(size: 30, weight: .bold))
                        .foregroundColor(.green)
            }
                    .frame(maxWidth: .infinity)
                    .frame(height: 100, alignment: .center)

            TextInputField(
                    value: $username,
                    label: "User Name",
                    placeHolder: "someone"
            )

            PasswordTextInputField(
                    value: $password,
                    label: "Password",
                    placeHolder: ""
            ).padding(.top, 25)

            Spacer()

            Button(action: handleCreateUserAction) {
                HStack(alignment: .center) {
                    Text("Create Account")
                            .foregroundColor(Color.green)
                            .font(.headline)
                }
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 15)
                        .overlay(RoundedRectangle(cornerRadius: 16).stroke(Color.green))
                        .cornerRadius(15)
                        .padding(.bottom, 20)

            }

            Button(action: {
            }) {
                HStack(alignment: .center) {
                    Text("Login")
                            .foregroundColor(.white)
                            .font(.headline)
                }
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 15)
                        .background(Color.green)
                        .cornerRadius(15)
            }
                    .padding(.bottom, 50)
            
            // Navigation Links
            NavigationLink(
                "",
                destination: NameScreenView(),
                isActive: $isNameScreenLinkActive
            )

        }
                .padding(.horizontal, 20)
        
    }
}

struct StartScreenView_Previews: PreviewProvider {
    static var previews: some View {
        StartScreenView()
    }
}
