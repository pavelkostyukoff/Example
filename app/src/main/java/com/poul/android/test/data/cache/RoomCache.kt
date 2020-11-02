
package com.poul.android.test.data.cache

import kotlinx.coroutines.flow.Flow

class RoomCache(private val postDao: PostDao) : Cache {

  override fun getAllPosts(): Flow<List<CachedExample>> {
    return postDao.getAllPost()
  }

  override fun getFavoritePosts(): Flow<List<CachedExample>> {
    return postDao.getFavoritePost()
  }

  override fun updateCachedPosts(exm: List<CachedExample>) {
    return postDao.insert(exm)
  }

  override fun updatePostsFavoriteStatus(picture: String, isFavorite: Boolean) {
    postDao.update(picture, isFavorite)
  }
}