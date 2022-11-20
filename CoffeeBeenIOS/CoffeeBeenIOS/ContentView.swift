//
//  ContentView.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 20/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import UIPilot

struct ContentView: View {
    @StateObject var pilot = UIPilot(initial: AppRoute.start)

    var body: some View {
        UIPilotHost(pilot) { route in
            switch route {
                case .start: StartScreenView()
                case .name: NameScreenView()
                case .username(let firstName, let lastName) : EmailScreenView(
                    firstName: firstName,
                    lastName: lastName
                )
                case .password(let firstName, let lastName, let email, let username):
                    PasswordScreenView(
                        firstName: firstName,
                        lastName: lastName,
                        email: email,
                        username: username
                    )
            }
        }
    }
}
