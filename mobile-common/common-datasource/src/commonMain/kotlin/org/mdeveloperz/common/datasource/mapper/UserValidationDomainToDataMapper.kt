package org.mdeveloperz.common.datasource.mapper

import org.mdeveloperz.common.datasource.bases.DomainToDataMapper
import org.mdeveloperz.common.datasource.model.UserValidationDataModel
import org.mdeveloperz.mobile.common.domain.model.UserValidationModel

class UserValidationDomainToDataMapper :
    DomainToDataMapper<UserValidationModel, UserValidationDataModel>() {
    override fun toData(domain: UserValidationModel) = UserValidationDataModel(
        email = domain.email,
        username = domain.username
    )
}