//
//  HiddenIfModifier+Extension.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 19/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI

struct HiddenIfModifier: ViewModifier {
    var isHidden: Bool
    
    init(condition: Bool) {
        self.isHidden = condition
    }
    
    func body(content: Content) -> some View {
        content
            .opacity(isHidden ? 0 : 1)
            .disabled(isHidden)
    }
}

extension View {
    func hidden(if condition: Bool) -> some View {
        modifier(HiddenIfModifier(condition: condition))
    }
}
