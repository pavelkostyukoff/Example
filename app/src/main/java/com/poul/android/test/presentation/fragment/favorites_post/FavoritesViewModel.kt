
package com.poul.android.test.presentation.fragment.favorites_post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.poul.android.test.domain.Post
import com.poul.android.test.domain.ExapleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class FavoritesViewModel(private val repository: ExapleRepository) : ViewModel() {

  val favoritePosts: LiveData<List<Post>>
      get() = _favoritePosts

  private val _favoritePosts: MutableLiveData<List<Post>> = MutableLiveData()

  init {
    observeCacheUpdates()
  }

  private fun observeCacheUpdates() {
    viewModelScope.launch {
      repository.getCachedFavoriteExample()
          .flowOn(Dispatchers.IO)
          .collect { handle(it) }
    }
  }

  private fun handle(posts: List<Post>) {
    _favoritePosts.value = posts
  }
}