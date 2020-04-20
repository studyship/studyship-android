package com.studyship.application.ui.adapter.holder.delegate

import com.skydoves.transformationlayout.TransformationLayout

interface IRecyclerDelegate {
    fun onClickItem(position: Int, translateLayout: TransformationLayout)
}