package com.abhijith.networkcaching.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.abhijith.networkcaching.db.models.Media
import com.abhijith.networkcaching.db.models.PostLD
import com.abhijith.networkcaching.db.models.PostLDAndMedia

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPost(post: PostLD)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPostMedia(media: Media)

    @Query("Select * from PostLD")
    fun getAllPost(): LiveData<List<PostLD>>

    @Query("select * from media where media.post_id == (:id)")
    fun getMedia(id: String):Media

    @Query("select * from PostLD")
    fun getAllMedia():LiveData<List<PostLDAndMedia>>
}