package com.abhijith.networkcaching.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Px
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

var isScrollingFast: Boolean = false

class MyRecyclerView : RecyclerView {
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int)
            : super(context!!, attrs, defStyleAttr)

    constructor(context: Context?, attrs: AttributeSet?)
            : super(context!!, attrs)

    constructor(context: Context?, color: Int) : super(context!!) {

    }

    constructor(context: Context?) : super(context!!) {}

    //todo
//    private val listOfAttachedCandidates = mutableListOf<>()

    companion object {
        var isScrolledDown = false
        var isScrolled = false
        var isJustStarted: Boolean = true
    }

    init {
    }

    override fun onChildAttachedToWindow(child: View) {
        super.onChildAttachedToWindow(child)
        val childViewHolder = getChildViewHolder(child)
//        todo(lost Attavhed)
//        listOfAttachedCandidates.add(VH)
    }


    override fun onChildDetachedFromWindow(child: View) {
        super.onChildDetachedFromWindow(child)
//todo action(attatched)
        //        listOfAttachedCandidates.remove(VH)
    }


    override fun onScrolled(@Px dx: Int, @Px dy: Int) {
        super.onScrolled(dx, dy)
        isScrolledDown = dy < 0
        isScrollingFast = true
        isScrolled = true
    }

    var lastScrollFocus: Int = -1

    override fun onScrollStateChanged(state: Int) {
        super.onScrollStateChanged(state)

        val visibleItemPosition: Int = if (!isScrolledDown) {
            if ((layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == -1 && state == SCROLL_STATE_IDLE)
                (layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            else
                (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
        } else {
            if ((layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition() == -1 && state == SCROLL_STATE_IDLE)
                (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
            else
                (layoutManager as LinearLayoutManager).findLastCompletelyVisibleItemPosition()
        }

        if (visibleItemPosition != -1)
            when (state) {
                SCROLL_STATE_IDLE -> {
                    isScrollingFast = false
                    if (lastScrollFocus != visibleItemPosition) {
                        lastScrollFocus = visibleItemPosition
//                        todo
//                        listOfAttachedCandidates.forEach { postViewHolder ->
//                            (postViewHolder as ViewHolderExtension).apply {
//                                action(
//                                    if (postViewHolder.myPosition == visibleItemPosition)
//                                        ExtensionInfo(SelectiveAction.ATTACHED_WIN)
//                                    else
//                                        ExtensionInfo(SelectiveAction.ATTACHED_LOST)
//                                )
//                            }
                        }

                }
                SCROLL_STATE_DRAGGING -> {
                }
                SCROLL_STATE_SETTLING -> {
                }
            }
    }
}