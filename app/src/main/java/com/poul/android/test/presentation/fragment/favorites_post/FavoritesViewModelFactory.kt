

package com.poul.android.test.presentation.fragment.favorites_post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poul.android.test.domain.ExapleRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Suppress("UNCHECKED_CAST")
object FavoritesViewModelFactory : ViewModelProvider.Factory {

  private lateinit var repository: ExapleRepository

  fun inject(repository: ExapleRepository) {
    FavoritesViewModelFactory.repository = repository
  }

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return FavoritesViewModel(repository) as T
  }
}