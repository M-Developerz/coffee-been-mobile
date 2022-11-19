//
//  CaptureNameScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct NameScreenView: View {
    @State private var firstName: String = ""
    @State private var lastName: String = ""
    @State private var showUserNameAndEmailScreen = false
    
    var body: some View {
        VStack {
            RegistrationHeaderView()
                        
            TextInputField(
                value: $firstName,
                label: "First Name",
                placeHolder: "John"
            ).padding(.top, 40)
            
            TextInputField(
                value: $lastName,
                label: "Last Name",
                placeHolder: "Doe"
            ).padding(.top, 20)
            
            Spacer()
            
            Button(action: {
                showUserNameAndEmailScreen.toggle()
            }) {
                HStack (alignment: .center) {
                    Text("Input Account")
                        .foregroundColor(.white)
                        .font(.headline)
                }.frame(maxWidth: .infinity)
                    .padding(.vertical, 15)
                    .background(Color.green)
                    .cornerRadius(15)
            }.padding(.bottom, 50)
                .padding(.top, 100)
            
            NavigationLink(destination: EmailScreenView(), isActive: $showUserNameAndEmailScreen) {}
            
        }.padding(.horizontal, 20)
    }
}

struct CaptureNameScreenView_Previews: PreviewProvider {
    static var previews: some View {
        NameScreenView()
    }
}
