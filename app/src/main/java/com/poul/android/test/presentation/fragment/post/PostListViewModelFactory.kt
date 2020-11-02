
package com.poul.android.test.presentation.fragment.post

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poul.android.test.domain.ExapleRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
@Suppress("UNCHECKED_CAST")
object PostListViewModelFactory : ViewModelProvider.Factory {

  private lateinit var repository: ExapleRepository

  fun inject(repository: ExapleRepository) {
    PostListViewModelFactory.repository = repository
  }

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return PostListViewModel(repository) as T
  }
}