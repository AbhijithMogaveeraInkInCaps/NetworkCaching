package com.abhijith.networkcaching.adapters

import androidx.annotation.Nullable
import androidx.recyclerview.widget.DiffUtil
import com.abhijith.networkcaching.db.models.PostLDAndMedia

class RatingDiffCallback(private val oldList: List<PostLDAndMedia>, private val newList: List<PostLDAndMedia>) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    override fun areContentsTheSame(oldPosition: Int, newPosition: Int): Boolean {
        return oldList[oldPosition].postLD.post_id==newList[newPosition].postLD.post_id
    }

    @Nullable
    override fun getChangePayload(oldPosition: Int, newPosition: Int): Any? {
        return super.getChangePayload(oldPosition, newPosition)
    }
}