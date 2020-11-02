
package com.poul.android.test.data.cache

import kotlinx.coroutines.flow.Flow

interface Cache {

  fun getAllPosts(): Flow<List<CachedExample>>
  fun getFavoritePosts(): Flow<List<CachedExample>>
  fun updateCachedPosts(picabuses: List<CachedExample>)
  fun updatePostsFavoriteStatus(postPicture: String, isFavorite: Boolean)
}