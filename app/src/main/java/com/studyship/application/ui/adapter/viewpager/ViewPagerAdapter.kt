package com.studyship.application.ui.adapter.viewpager

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.studyship.application.R
import com.studyship.application.ui.adapter.holder.viewpager.ViewPagerTest

class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerTest>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerTest {
        return ViewPagerTest(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recycler_view_pager_item, parent, false)
        )
    }

    override fun getItemCount(): Int = 5

    override fun onBindViewHolder(holder: ViewPagerTest, position: Int) {
        holder.bind("Here is $position Position View")
    }
}