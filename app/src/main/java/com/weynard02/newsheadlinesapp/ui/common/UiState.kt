package com.weynard02.newsheadlinesapp.ui.common

sealed class UiState<out R> private constructor() {

    object Loading : UiState<Nothing>()

    data class Success<out T: Any>(val data: T) : UiState<T>()

    data class Error(val errorMessage: String) : UiState<Nothing>()
}