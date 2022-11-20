//
//  AppRoute.swift
//  CoffeeBeenIOS
//
//  Created by Simon Peter Ojok on 20/11/2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation

enum AppRoute: Equatable {
    case start
    case name
    case username(
        firstName: String,
        lastName: String
    )
    case password(
        firstName: String,
        lastName: String,
        email: String,
        username: String
    )
}
