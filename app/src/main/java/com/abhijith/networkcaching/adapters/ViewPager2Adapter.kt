package com.abhijith.networkcaching.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.abhijith.networkcaching.R
import com.abhijith.networkcaching.db.models.Media
import com.abhijith.networkcaching.extension.ExtensionInfo
import com.abhijith.networkcaching.extension.SelectiveAction
import com.abhijith.networkcaching.extension.ViewHolderExtension
import com.bumptech.glide.Glide


class ViewPager2Adapter(val list:List<Media>) : RecyclerView.Adapter<ViewPager2Adapter.PostImageViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostImageViewHolder {
//        return when (viewType) {

//            VIEW_TYPE_VIDEO -> {
            return PostImageViewHolder(
                    LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.fragment_photo, parent, false)
                )
//            }

//            VIEW_TYPE_IMAGE -> {
//                PostImageViewHolder(
//                    LayoutInflater
//                        .from(parent.context)
//                        .inflate(R.layout.fragment_video, parent, false)
//                )
//            }
//            else -> {
//                throw Exception("This type of content is not supported yet..!")
//            }
//        }
    }

//    val videoViewHolderList: MutableList<RecyclerView.ViewHolder> = mutableListOf()

    override fun onBindViewHolder(holder: PostImageViewHolder, position: Int) {

//        holder.runWhenVideo {
//            videoViewHolderList.add(it)
        Glide.with(holder.v.context).load(list[position].location).into(holder.v)
//        Picasso.get().load(list[position].location).into(holder.v)
//            it.myPosition = position
//            it.setData(model.viewPagerData[position])
//        }

//        holder.runWhenImage {
//
//        }

    }

//    override fun getItemViewType(position: Int): Int {
//        return when (model.viewPagerData[position].dataType) {
//            RecyclerViewStateModel.DataType.IMAGE -> {
//                VIEW_TYPE_IMAGE
//            }
//            RecyclerViewStateModel.DataType.VIDEO -> {
//                VIEW_TYPE_VIDEO
//            }
//        return 0
//
//    }

    override fun getItemCount(): Int {
//        return model.viewPagerData.size
        return list.size
    }

    lateinit var currentVideoViewHolder: RecyclerView.ViewHolder

    fun pauseAllOperations() {
        currentVideoViewHolder.runWhenVideo {
//            it.imageView.beVisible()
//            it.action(ExtensionInfo(SelectiveAction.ATTACHED_LOST))
        }
        currentVideoViewHolder.runWhenImage {

        }
    }

    fun resumeAllOperation() {
        currentVideoViewHolder.runWhenVideo {
//            it.imageView.beInvisible()
//            it.action(ExtensionInfo(SelectiveAction.ATTACHED_WIN))
        }
    }

    fun freeMemory() {
//        videoViewHolderList.forEach { holder ->
//            holder.runWhenVideo {
//                it.mySimpleExoPlayer.freeMemory()
//            }
//        }
    }

    fun initAndSeekToOne() {
//        videoViewHolderList.forEach { vh ->
//            vh.runWhenVideo {
//                it.mySimpleExoPlayer.allocateMemoryAndBeReady(it.vData)
            }
//            vh.runWhenImage {
//
//            }
//        }


    class PostVideoViewHolder(v: View) : RecyclerView.ViewHolder(v), ViewHolderExtension {
        //        lateinit var vData: RecyclerViewStateModel.SubViewHolderData
        override fun action(extensionInfo: ExtensionInfo) {
            when (extensionInfo.action) {

                SelectiveAction.NONE -> {

                }

                SelectiveAction.ATTACHED_WIN -> {
//                    if (this::vData.isInitialized) {
//                        mySimpleExoPlayer.play(vData)
//                    }

                }

                SelectiveAction.ATTACHED_LOST -> {
//                    if (this::vData.isInitialized) {
//                        mySimpleExoPlayer.pause(vData)
//                    }
                }

                SelectiveAction.ATTACHED_CANDIDATE -> {

                }

                SelectiveAction.DETACHED -> {

                }
            }
        }

    }

    class PostImageViewHolder(v: View) : RecyclerView.ViewHolder(v), ViewHolderExtension {
        val v:ImageView = v.findViewById(R.id.imageview)

        override fun action(extensionInfo: ExtensionInfo) {
            when (extensionInfo.action) {

                SelectiveAction.NONE -> {

                }

                SelectiveAction.ATTACHED_WIN -> {

                }

                SelectiveAction.ATTACHED_LOST -> {

                }

                SelectiveAction.ATTACHED_CANDIDATE -> {

                }

                SelectiveAction.DETACHED -> {

                }
            }
        }


    }

    private fun RecyclerView.ViewHolder.runWhenVideo(callback: (PostVideoViewHolder) -> Unit) {
        if (this is PostVideoViewHolder) {
            callback(this)
        }
    }

    private fun RecyclerView.ViewHolder.runWhenImage(callback: (PostImageViewHolder) -> Unit) {
        if (this is PostImageViewHolder) {
            callback(this)
        }
    }

    companion object {
        private const val VIEW_TYPE_IMAGE: Int = 1
        private const val VIEW_TYPE_VIDEO: Int = 2
    }
}

