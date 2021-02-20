package com.abhijith.networkcaching.api.models

data class Media(
    val seq:String,
    val name:String,
    val type:String,
    val location:String,
    val liked_by:List<Any>,
    val total_likes:Int,
    val liked_by_you:Int,
    val commented_by:List<Any>,
    val total_comments:Int,
)