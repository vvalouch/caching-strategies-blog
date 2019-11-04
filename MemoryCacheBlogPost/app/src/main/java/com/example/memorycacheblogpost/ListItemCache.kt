package com.example.memorycacheblogpost

class ListItemCache private constructor() {

    private val itemList = ArrayList<ListItem>()
    private var observer: (itemList: List<ListItem>) -> Any = {}

    companion object {
        public val shared = ListItemCache()
    }

    fun setObserver(inObserver: (itemList: List<ListItem>) -> Any) {
        observer = inObserver
        observer(itemList)
    }

    fun cleanObserver() {
        observer = {}
    }

    fun replaceItems(items: List<ListItem>) {
        itemList.clear()
        itemList.addAll(items)
        observer(itemList)
    }

    fun addItem(item: ListItem) {
        if (!this.itemList.contains(item)) {
            this.itemList.add(item)
            observer(itemList)
        }
    }

    fun getItems(): ArrayList<ListItem> {
        return itemList
    }

    fun getItem(position: Int): ListItem? {
        return itemList.getOrNull(position)
    }

    fun clean() {
        this.itemList.clear()
        observer(itemList)
    }
}

/* The structure of ListItem is not important how blog post but I am including it just for reference*/
data class ListItem(
    var vendorName: String = "vendor",
    var score: Int = 0
)
