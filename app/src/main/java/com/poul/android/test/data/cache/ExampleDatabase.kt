
package com.poul.android.test.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [
      CachedExample::class
    ],
    version = 1
)
abstract class ExampleDatabase : RoomDatabase() {

  abstract fun exampleDao(): PostDao
}