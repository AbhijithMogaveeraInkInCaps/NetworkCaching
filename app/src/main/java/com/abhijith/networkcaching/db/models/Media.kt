package com.abhijith.networkcaching.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = PostLD::class,
            parentColumns = ["post_id"],
            childColumns = ["post_id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Media(
    @PrimaryKey(autoGenerate = true)
    val id:Int? = null,
    @ColumnInfo(index = true) var post_id: String,
    @ColumnInfo var seq: String,
    @ColumnInfo var name: String,
    @ColumnInfo var type: String,
    @ColumnInfo var location: String,
//    @ColumnInfo var liked_by: List<Any>,
    @ColumnInfo var total_likes: Int,
    @ColumnInfo var liked_by_you: Int,
//    @ColumnInfo var commented_by: List<Any>,
    @ColumnInfo var total_comments: Int,
){


}