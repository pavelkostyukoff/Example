
package com.poul.android.test.data.cache

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.poul.android.test.domain.Post

@Entity(tableName = "Example")
data class CachedExample(
    @PrimaryKey
    @ColumnInfo(index = true)
    val id: Int?,
    val title: String?,
    val picture: String?,
    val body: String?,
    val isFavourite: Boolean = false
) {

  fun toDomainEntity(): Post = Post(id,title, picture, body, isFavourite)
}
