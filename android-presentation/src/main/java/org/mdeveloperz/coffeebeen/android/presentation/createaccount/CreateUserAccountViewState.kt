package org.mdeveloperz.coffeebeen.android.presentation.createaccount

import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState
import org.mdeveloperz.coffeebeen.android.presentation.bases.LoadingState.IDL
import org.mdeveloperz.coffeebeen.android.presentation.bases.ViewState

data class CreateUserAccountViewState(
    val loadingState: LoadingState = IDL
): ViewState

val EMPTY_STATE = CreateUserAccountViewState()

val CreateUserAccountViewState.isLoading
    get() = loadingState == LoadingState.Loading