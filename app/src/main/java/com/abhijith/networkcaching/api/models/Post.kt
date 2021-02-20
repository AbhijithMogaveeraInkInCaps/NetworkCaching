package com.abhijith.networkcaching.api.models

import retrofit2.http.Field

data class Post(
    val post_id:String,
    @Field("userid") val user_id:String,
    val name:String,
    @Field("username") val user_name:String,
    val profile_image:String,
    val description:String,
    val location:String,
    val post_type:String,
    val indian_time: String,
    val utc_time:String,
    val media:List<Media>,
    val comments:String,
    val total_likes:String,
    val total_comments: String,
    val commented_by: List<Any>,
    val liked_by: List<Any>,
    val liked_by_you: String,
    @Field("hashtags")val hash_tags:String,
    val mentions:String,
    val is_self:Boolean,
    val nudity:Boolean,
    val disable_comment:Boolean,
    val disable_reaction:Boolean,
    val aspect_ratio:Float
)