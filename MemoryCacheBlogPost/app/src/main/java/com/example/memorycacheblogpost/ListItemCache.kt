package com.example.memorycacheblogpost

import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


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

interface Storage<T> {
    fun storeAll(items: List<T>): Boolean
    fun getAll(): List<T>
}

class SharedPrefStorage(val sharedPreferences: SharedPreferences, val gson: Gson) :
    Storage<ListItem> {
    companion object {
        public const val LIST_ITEM_KEY = "list.item.key"
    }

    override fun storeAll(items: List<ListItem>): Boolean {
        val itemString = gson.toJson(items)
        return sharedPreferences.edit().putString(LIST_ITEM_KEY, itemString).commit()
    }

    override fun getAll(): List<ListItem> {
        val json = sharedPreferences.getString(LIST_ITEM_KEY, "")
        val collectionType = TypeToken.getParameterized(List::class.java, ListItem::class.java).type
        return gson.fromJson(json, collectionType)
    }

}
