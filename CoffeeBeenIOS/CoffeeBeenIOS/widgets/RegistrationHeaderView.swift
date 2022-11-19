//
//  RegistrationHeaderView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct RegistrationHeaderView: View {
    @State var headerTitle: String = "Input Your Name"
    
    var body: some View {
        VStack(alignment: .leading) {
            Text("Create New Account")
                .font(.system(size: 30))
                .lineLimit(nil)
            
            Text(headerTitle)
                .font(.subheadline)
                .lineLimit(nil)
            
        }.frame(maxWidth: .infinity, alignment: .topLeading)
            .padding(.vertical, 20)
        
    }
}

struct RegistrationHeaderView_Previews: PreviewProvider {
    static var previews: some View {
        RegistrationHeaderView()
    }
}
