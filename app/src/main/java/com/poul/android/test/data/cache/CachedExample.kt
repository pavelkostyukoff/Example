
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
    val name: String?,
    val date: String?,
    val picture: String?,
    val body: String?,
    val isFavourite: Boolean = false,
    val missionName: String?,
    val startImage: String?,
    val webLink: String?
    ) {

  fun toDomainEntity(): Post = Post(id,title,name,date, picture, body, isFavourite, missionName, startImage, webLink)
}
