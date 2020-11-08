package com.studyship.application.ui.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainCategoryDecoration(private val space: Int) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val isLast = position == state.itemCount - 1


        if (isLast) {
            outRect.bottom = space;
            outRect.top = 0; //don't forget about recycling...
        }
        if (position != 0) {
            outRect.top = space;
            // don't recycle bottom if first item is also last
            // should keep bottom padding set above
        }
    }
}