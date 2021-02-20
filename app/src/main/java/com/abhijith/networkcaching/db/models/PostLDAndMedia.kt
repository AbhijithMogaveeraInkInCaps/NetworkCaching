package com.abhijith.networkcaching.db.models

import androidx.room.Embedded
import androidx.room.Relation


data class PostLDAndMedia(
    @Embedded
    var postLD: PostLD,
    @Relation(
        parentColumn = "post_id",
        entityColumn = "post_id"
    )
    var postList:List<Media>
)