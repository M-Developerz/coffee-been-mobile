//
//  CapturePasswordScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct PasswordScreenView: View {
    @State private var password: String = ""
    @State private var confirmPassword: String = ""
    
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
            
            Button(action: {} ) {
                HStack (alignment: .center) {
                    Text("Create Password")
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

struct PasswordScreenView_Previews: PreviewProvider {
    static var previews: some View {
        PasswordScreenView()
    }
}
