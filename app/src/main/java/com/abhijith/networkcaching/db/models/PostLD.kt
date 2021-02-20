package com.abhijith.networkcaching.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PostLD(

    @PrimaryKey(autoGenerate = false) var post_id: String,
    @ColumnInfo var user_id: String="",
    @ColumnInfo var name: String,
    @ColumnInfo var user_name: String,
    @ColumnInfo var profile_image: String,
    @ColumnInfo var description: String,
    @ColumnInfo var location: String,
    @ColumnInfo var post_type: String,
    @ColumnInfo var indian_time: String,
    @ColumnInfo var utc_time: String,
//    @ColumnInfo var media: List<Media>,
    @ColumnInfo var comments: String,
    @ColumnInfo var total_likes: String,
    @ColumnInfo var total_comments: String,
//    @ColumnInfo var commented_by: List<Any>,
//    @ColumnInfo var liked_by: List<Any>,
    @ColumnInfo var liked_by_you: String,
    @ColumnInfo var hash_tags: String,
    @ColumnInfo var mentions: String,
    @ColumnInfo var is_self: Boolean,
    @ColumnInfo var nudity: Boolean,
    @ColumnInfo var disable_comment: Boolean,
    @ColumnInfo var disable_reaction: Boolean,
    @ColumnInfo var aspect_ratio: Float
)

