package org.mdeveloperz.coffeebeen.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserDomainToPresentationMapper
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserPresentationToDomainMapper
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserValidationDomainToPresentationMapper
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserValidationPresentationToDomainMapper

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule {
    @Provides
    fun providesUserDomainToPresentationMapper() = UserDomainToPresentationMapper()

    @Provides
    fun providesUserPresentationToDomainMapper() = UserPresentationToDomainMapper()

    @Provides
    fun providesUserValidationDomainToPresentationMapper() =
        UserValidationDomainToPresentationMapper()

    @Provides
    fun providesUserValidationPresentationToDomainMapper() =
        UserValidationPresentationToDomainMapper()
}