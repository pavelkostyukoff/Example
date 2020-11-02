
package com.poul.android.test.presentation.fragment.postdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.poul.android.test.domain.ExapleRepository

@Suppress("UNCHECKED_CAST")
object ExampleViewModelFactory : ViewModelProvider.Factory {

  private lateinit var repository: ExapleRepository

  fun inject(repository: ExapleRepository) {
    ExampleViewModelFactory.repository = repository
  }

  override fun <T : ViewModel?> create(modelClass: Class<T>): T {
    return ExampleViewModel(repository) as T
  }
}