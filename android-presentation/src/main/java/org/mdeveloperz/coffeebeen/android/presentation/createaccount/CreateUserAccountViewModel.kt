package org.mdeveloperz.coffeebeen.android.presentation.createaccount

import dagger.hilt.android.lifecycle.HiltViewModel
import org.mdeveloperz.coffeebeen.android.presentation.bases.BaseViewModel
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState.Loading
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState.Success
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState.Error
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserPresentationToDomainMapper
import org.mdeveloperz.coffeebeen.android.presentation.model.UserPresentationModel
import org.mdeveloperz.mobile.common.domain.usecase.CreateUserAccountUseCase
import javax.inject.Inject

@HiltViewModel
class CreateUserAccountViewModel @Inject constructor(
    private val createUserAccountUseCase: CreateUserAccountUseCase,
    private val userDomainMapper: UserPresentationToDomainMapper
) : BaseViewModel<CreateUserAccountViewState>() {
    override fun initializeState() = EMPTY_STATE

    fun onCreateUserAction(user: UserPresentationModel) {
        updateState { prevState -> prevState.copy(loadingState = Loading) }
        execute(
            input = userDomainMapper.toDomain(user),
            useCase = createUserAccountUseCase,
            onResult = { userModel ->
                updateState { prevState -> prevState.copy(loadingState = Success()) }
                println(userModel)
            },
            onError = { error ->
                updateState { prevState -> prevState.copy(loadingState = Error()) }
                println(error)
            }
        )
    }
}