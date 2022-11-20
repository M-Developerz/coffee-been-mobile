package org.mdeveloperz.coffeebeen.android.presentation.validateuser

import dagger.hilt.android.lifecycle.HiltViewModel
import org.mdeveloperz.coffeebeen.android.presentation.bases.BaseViewModel
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState.Success
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserValidationDomainToPresentationMapper
import org.mdeveloperz.coffeebeen.android.presentation.mapper.UserValidationPresentationToDomainMapper
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationModel
import org.mdeveloperz.mobile.common.domain.usecase.ValidateUserUseCase
import javax.inject.Inject

@HiltViewModel
class UserValidationViewModel @Inject constructor(
    private val validateUserUseCase: ValidateUserUseCase,
    private val userValidationDomainMapper: UserValidationDomainToPresentationMapper,
    private val userValidationPresentationMapper: UserValidationPresentationToDomainMapper
) : BaseViewModel<UserValidationViewState>() {

    override fun initializeState() = EMPTY_STATE

    fun onValidUserAction(user: UserValidationPresentationModel) {

        updateState { prevState ->
            prevState.copy(
                loadingState = LoadingState.Loading,
                data = EMPTY_STATE.data
            )
        }

        execute(
            input = userValidationPresentationMapper.toDomain(user),
            useCase = validateUserUseCase,
            onError = { error ->
                println(error)
            },
            onResult = { domain ->
                updateState { prevState ->
                    prevState.copy(
                        loadingState = Success(),
                        data = userValidationDomainMapper.toPresentation(domain)
                    )
                }
            }
        )
    }


}