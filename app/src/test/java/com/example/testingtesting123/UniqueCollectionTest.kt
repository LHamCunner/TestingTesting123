package com.example.testingtesting123

import org.junit.Assert.*

import org.junit.Before
import org.junit.Test

class UniqueCollectionTest {

    lateinit var collection: UniqueCollection

    @Before
    fun setUp() {
        collection = UniqueCollection()
    }

    @Test
    fun addAnItem() {
        collection.addItem(Item("Item1"))
        val item = collection.get(0)
        assert(item.name == "Item1")
    }

    @Test
    fun addUniqueItem() {
        collection.addItem(Item("Item1"))
        collection.addItem(Item("item1"))
        collection.addItem(Item("Item2"))

        assert (collection.size() == 2)
    }

    @Test
    fun clearAllItems() {
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))

        val originalSize = collection.size()
        collection.clear()
        val newSize = collection.size();

        assert(originalSize == 2 && newSize == 0) {"Items not cleared"}
    }

    @Test
    fun removeItem(){
        collection.remove(Item("item1"))
        assert(collection.size() == 0)
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))

        collection.remove(Item("item3"))

        assert(collection.size() == 2)

        collection.remove(Item("item1"))

        assert(collection.size() == 1)
        assert((collection.get(0)).name != "item1")
        assert((collection.get(0)).name == "item2")

        collection.remove(Item("item2"))

        assert(collection.size() == 0)
    }

    @Test
    fun getPosition(){
        collection.addItem(Item("item1"))
        collection.addItem(Item("item2"))


        assert((collection.get(0)).name == "item1"){"wrong item in position"}
        assert((collection.get(0)).name != "item2"){"right item in position"}
        assert((collection.get(1)).name == "item2"){"wrong item in position"}
    }

    @Test
    fun collectionSize(){
        collection.addItem(Item("item1"))
        assert(collection.size() == 1){"Size wrong"}
        collection.addItem(Item("Item2"))

        assert(collection.size() == 2){"Size wrong"}
    }
}