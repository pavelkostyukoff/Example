
package com.poul.android.test.data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PostDao {

  @Query("SELECT * FROM Example")
  fun getAllPost(): Flow<List<CachedExample>>

  @Query("SELECT * FROM Example WHERE isFavourite = 1")
  fun getFavoritePost(): Flow<List<CachedExample>>

  @Insert(onConflict = OnConflictStrategy.IGNORE)
  fun insert(exm: List<CachedExample>)

  @Query("UPDATE Example SET isFavourite = :isFavorite WHERE picture = :postPicture")
  fun update(postPicture: String, isFavorite: Boolean)
}