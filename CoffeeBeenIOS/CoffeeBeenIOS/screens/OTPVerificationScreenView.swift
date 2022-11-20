//
//  OTPVerificationScreenView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct OTPVerificationScreenView: View {
    var body: some View {
        VStack {
            RegistrationHeaderView(
                    headerTitle: "Input Your Password"
            )

            Spacer()
        }
                .padding(.horizontal, 20)
    }
}

struct OTPVerificationScreenView_Previews: PreviewProvider {
    static var previews: some View {
        OTPVerificationScreenView()
    }
}
