package com.abhijith.networkcaching.repo

import android.util.Log
import androidx.lifecycle.LiveData
import com.abhijith.networkcaching.api.RetrofitInstance
import com.abhijith.networkcaching.api.models.Main
import com.abhijith.networkcaching.db.PostDatabase
import com.abhijith.networkcaching.db.models.Media
import com.abhijith.networkcaching.db.models.PostLD
import com.abhijith.networkcaching.db.models.PostLDAndMedia
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostRepo(val db: PostDatabase) {
    fun getLatestPost(): LiveData<List<PostLDAndMedia>> {
        RetrofitInstance.api.getAllPost().enqueue(object : Callback<Main> {
            override fun onResponse(call: Call<Main>, response: Response<Main>) {
                if (response.isSuccessful) {
                    response.body()?.response?.let { main ->
                        main.post.forEach { post ->
                            GlobalScope.launch {
                                db.getPostDao().insertPost(
                                    PostLD(
                                        post_id = post.post_id?:"",
                                        user_id = post.user_id?:"",
                                        name = post.name?:"",
                                        user_name = post.user_name?:"",
                                        profile_image = post.profile_image?:"",
                                        description = post.description?:"",
                                        location = post.location?:"",
                                        post_type = post.post_type?:"",
                                        indian_time = post.indian_time?:"",
                                        utc_time = post.utc_time?:"",
                                        comments = post.comments?:"",
                                        total_likes = post.total_likes?:"",
                                        total_comments = post.total_comments?:"",
                                        liked_by_you = post.liked_by_you?:"",
                                        hash_tags = post.hash_tags?:"",
                                        mentions = post.mentions?:"",
                                        is_self = post.is_self,
                                        nudity = post.nudity,
                                        disable_comment = post.disable_comment,
                                        disable_reaction = post.disable_reaction,
                                        aspect_ratio = post.aspect_ratio
                                    )
                                )
                                post.media.forEach { media ->
                                    db.getPostDao().insertPostMedia(
                                        Media(
                                            post_id = post.post_id,
                                            seq = media.seq,
                                            name = media.name,
                                            type = media.type,
                                            location = media.location,
                                            liked_by_you = media.liked_by_you,
                                            total_likes = media.total_likes,
                                            total_comments = media.total_comments
                                        )
                                    )
                                    Log.e("Ink","one media inserted ${post.post_id}")
                                }
                                Log.e("Ink","one post inserted ${post.post_id}")

                            }
                            }

                    }
                }
            }

            override fun onFailure(call: Call<Main>, t: Throwable) {

            }
        })
        return db.getPostDao().getAllMedia()
    }
}