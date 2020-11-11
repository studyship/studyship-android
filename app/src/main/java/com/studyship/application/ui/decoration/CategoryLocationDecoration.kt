package com.studyship.application.ui.decoration

import android.graphics.Rect
import android.util.TypedValue
import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView

class CategoryLocationDecoration(private val activity: FragmentActivity) :
    RecyclerView.ItemDecoration() {
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        val isLocationButton = position == 1

        val isDetailLocationLabel = position == 2

        if (isLocationButton) {
            outRect.bottom = convertTypedValue(21f, activity).toInt()
            outRect.top = convertTypedValue(8f, activity).toInt()
        }

        if (isDetailLocationLabel) {
            outRect.bottom = convertTypedValue(16f, activity).toInt()
        }

        if (position > 2) {
            outRect.bottom = convertTypedValue(28f, activity).toInt()
        }
    }

    companion object {
        private fun convertTypedValue(value: Float, activity: FragmentActivity): Float {
            return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                value,
                activity.resources.displayMetrics
            )
        }
    }
}