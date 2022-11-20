//
//  CaptureNameScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import UIPilot

struct NameScreenView: View {
    @EnvironmentObject var pilot: UIPilot<AppRoute>

    @State private var firstName: String = ""
    @State private var firstNameError: String? = nil
    @State private var lastName: String = ""
    @State private var lastNameError: String? = nil
    
    private func handleSubmitUsername() {
        firstNameError = firstName.isEmpty ? "Required" : nil
        lastNameError = lastName.isEmpty ? "Required" : nil
        
        if !firstName.isEmpty && !lastName.isEmpty {
            pilot.push(.username(firstName: firstName, lastName: lastName))
        }
    }
    
    
    var body: some View {
        VStack {
            RegistrationHeaderView()

            TextInputField(
                    value: $firstName,
                    label: "First Name",
                    errorMessage: firstNameError,
                    placeHolder: "John"
            ).padding(.top, 40)

            TextInputField(
                    value: $lastName,
                    label: "Last Name",
                    errorMessage: lastNameError,
                    placeHolder: "Doe"
            ).padding(.top, 20)

            Spacer()

            Button(action: handleSubmitUsername) {
                HStack(alignment: .center) {
                    Text("Input Account")
                            .foregroundColor(.white)
                            .font(.headline)
                }
                        .frame(maxWidth: .infinity)
                        .padding(.vertical, 15)
                        .background(Color.green)
                        .cornerRadius(15)
            }
                    .padding(.bottom, 50)
                    .padding(.top, 100)

        }
                .padding(.horizontal, 20)
    }
}

struct CaptureNameScreenView_Previews: PreviewProvider {
    static var previews: some View {
        NameScreenView()
    }
}
