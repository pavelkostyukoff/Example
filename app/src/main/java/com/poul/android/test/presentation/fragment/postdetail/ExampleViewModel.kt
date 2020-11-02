
package com.poul.android.test.presentation.fragment.postdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poul.android.test.domain.ExapleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ExampleViewModel(private val repository: ExapleRepository) : ViewModel() {

  fun updatePostFavoriteStatus(postPicture: String, isFavorite: Boolean) {
    viewModelScope.launch(Dispatchers.IO) {
      repository.updatePostFavoriteStatus(postPicture, isFavorite)
    }
  }
}