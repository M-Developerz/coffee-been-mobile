//
//  PasswordTextInputField.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct PasswordTextInputField: View {
    @Binding var value: String
    var label: String
    var errorMessage: String? = nil
    var placeHolder: String
    
    var body: some View {
        VStack(alignment: .leading) {
            Text(label)
                .foregroundColor(Color.gray)
            
            SecureField(placeHolder, text: $value)
                .frame(height: 55)
                .autocapitalization(.none)
                .textFieldStyle(PlainTextFieldStyle())
                .padding(.horizontal, 12)
                .cornerRadius(16)
                .overlay(RoundedRectangle(cornerRadius: 16).stroke(Color.gray))
            
            VStack(alignment: .trailing) {
                if errorMessage != nil {
                    Text(errorMessage!)
                        .foregroundColor(Color.red)
                }
            }.frame(maxWidth: .infinity, alignment: .trailing)
        }
    }
}
