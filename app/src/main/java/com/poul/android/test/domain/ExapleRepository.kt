
package com.poul.android.test.domain

import kotlinx.coroutines.flow.Flow

interface ExapleRepository {

  fun getCachedPost(): Flow<List<Post>>
  fun getCachedFavoriteExample(): Flow<List<Post>>
  suspend fun getApiExample(): List<Post>
  suspend fun updateCachedPost(posts: List<Post>)
  suspend fun updatePostFavoriteStatus(postPicture: String, isFavorite: Boolean)
}