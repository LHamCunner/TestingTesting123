package com.example.testingtesting123

class UniqueCollection {
    private val collection = ArrayList<Item>()

    fun addItem (item: Item) {
        if (!collection.contains(item))
            collection.add(item)
    }

    fun clear (){
        collection.clear()
    }

    fun get (position: Int) = collection[position]

    fun remove (item: Item){
        !collection.remove(item)
    }

    fun size() = collection.size


}