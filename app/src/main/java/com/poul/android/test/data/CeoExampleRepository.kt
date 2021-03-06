
package com.poul.android.test.data

import com.poul.android.test.data.api.Api
import com.poul.android.test.data.cache.Cache
import com.poul.android.test.data.cache.CachedExample
import com.poul.android.test.domain.Post
import com.poul.android.test.domain.ExapleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CeoExampleRepository(private val api: Api, private val cache: Cache) : ExapleRepository {

  override fun getCachedPost(): Flow<List<Post>> {
    return cache.getAllPosts()
        .map { it ->
          it.map { it.toDomainEntity() }
        }
  }

  override fun getCachedFavoriteExample(): Flow<List<Post>> {
    return cache.getFavoritePosts()
        .map { favoritePost ->
          favoritePost.map { it.toDomainEntity() }
        }
  }

  override suspend fun getApiExample(): List<Post> {
      return api.getPostLaunches().map {
          Post(it.flightNumber,it.rocket.rocketName, it.launchDateLocal, title = it.details, picture = it.links.missionPatchSmall, body = it.details, isFavourite = false, missionName = it.missionName, startImage = it.links.missionPatch, webLink = it.links.videoLink)
      }
  }

  override suspend fun updateCachedPost(posts: List<Post>) {
    cache.updateCachedPosts(posts.map {
                 CachedExample(it.id, it.rocketName, it.date,it.title, it.picture, it.body, it.isFavourite,it.missionName, it.startImage, it.webLink)
    })
  }

  override suspend fun updatePostFavoriteStatus(postPicture: String, isFavorite: Boolean) {
    cache.updatePostsFavoriteStatus(postPicture, isFavorite)
  }
}