package com.studyship.application.base.cache

interface IRecyclerAdapter : IRecyclerController {
    val notifiedChangePositionListener: OnClickNotifiedPositionListener

    val notifiedChangeItem: OnClickNotifiedListener

    val notifiedChangeRangeItemListener: OnClickNotifiedRangeListener

    val notifiedRemoveItemPosition: OnClickNotifiedPositionListener
}

interface IRecyclerController {
    fun addItem(viewType: Int, item: Any?)

    fun addItems(viewType: Int, itemList: List<Any>?)

    fun destroyedEvent()

    fun getItems(position: Int): Any?

    fun destroyedPositionItem(position: Int)
}

typealias OnClickNotifiedListener = () -> Unit
typealias OnClickNotifiedRangeListener = (Int, Int) -> Unit
typealias OnClickNotifiedPositionListener = (Int) -> Unit