
package com.poul.android.test

import android.app.Application
import androidx.room.Room
import com.poul.android.test.data.CeoExampleRepository
import com.poul.android.test.data.api.Api
import com.poul.android.test.data.cache.ExampleDatabase
import com.poul.android.test.data.cache.RoomCache
import com.poul.android.test.domain.ExapleRepository
import com.poul.android.test.presentation.fragment.postdetail.ExampleViewModelFactory
import com.poul.android.test.presentation.fragment.post.PostListViewModelFactory
import com.poul.android.test.presentation.fragment.favorites_post.FavoritesViewModelFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@ExperimentalCoroutinesApi
@InternalCoroutinesApi
class App : Application() {

  override fun onCreate() {
    super.onCreate()

    val repository = createRepository()

    PostListViewModelFactory.inject(repository)
    ExampleViewModelFactory.inject(repository)
    FavoritesViewModelFactory.inject(repository)
  }

  private fun createRepository(): ExapleRepository {
    val api = Api.create()
    val database = createDatabase()
    val dao = database.exampleDao()
    val cache = RoomCache(dao)

    return CeoExampleRepository(api, cache)
  }

  private fun createDatabase(): ExampleDatabase =
      Room.databaseBuilder(this, ExampleDatabase::class.java, "pikabu.db")
          .build()
}