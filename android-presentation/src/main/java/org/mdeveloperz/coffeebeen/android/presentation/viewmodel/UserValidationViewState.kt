package org.mdeveloperz.coffeebeen.android.presentation.viewmodel

import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState.IDL
import org.mdeveloperz.coffeebeen.android.presentation.bases.ViewState
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationResult
import org.mdeveloperz.coffeebeen.android.presentation.model.UserValidationPresentationResult.Empty

data class UserValidationViewState(
    val loadingState: LoadingState = IDL,
    val data: UserValidationPresentationResult = Empty
) : ViewState