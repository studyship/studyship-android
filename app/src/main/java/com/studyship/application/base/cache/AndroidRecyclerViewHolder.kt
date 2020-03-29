package com.studyship.application.base.cache

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

abstract class AndroidRecyclerViewHolder(override val containerView: View) :
    RecyclerView.ViewHolder(containerView), LayoutContainer