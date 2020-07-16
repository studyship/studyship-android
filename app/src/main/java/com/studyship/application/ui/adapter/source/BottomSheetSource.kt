package com.studyship.application.ui.adapter.source

sealed class BottomSheetSource {
    data class BottomSheetItem(val viewType: Int, val data: Any?)
}