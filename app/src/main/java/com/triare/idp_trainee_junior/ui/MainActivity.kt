package com.triare.idp_trainee_junior.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.R
import com.triare.idp_trainee_junior.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        playWithCollections()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frContainer, RandomCoffeeFragment.newInstance())
            .commit()

    }

    private fun playWithCollections() {
        val stringList = listOf("one", "two", "one")
        printAll(stringList)
        stringList.printSize()

        val stringSet = setOf("one", "two", "three")
        printAll(stringSet)
        stringSet.printSize()

        map()

        isMapsEqual()

        defaultMapIsLinkedHashMap()

    }

    private fun printAll(strings: Collection<String>) {
        Log.i(TAG, "-----------------------------")
        strings.forEach {
            Log.i(TAG, it)
        }
    }

    private fun map() {
        Log.i(TAG, "_________________________________________________________")
        Log.i(TAG, "All keys:")
        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
        Log.i(TAG, "All keys: ${numbersMap.keys}")
        Log.i(TAG, "All values: ${numbersMap.values}")
        if ("key2" in numbersMap) Log.i(TAG, "Value by key \"key2\": ${numbersMap["key2"]}")
        if (1 in numbersMap.values) Log.i(TAG, "The value 1 is in the map")
        if (numbersMap.containsValue(1)) Log.i(TAG, "The value 1 is in the map")
    }

    private fun Collection<String>.printSize() {
        Log.i(TAG, "________________________")
        Log.i(TAG, "${this.size}")
    }

    private fun isMapsEqual() {
        Log.i(TAG, "_________________________________________________________")

        val numbersMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3, "key4" to 1)
        val anotherMap = mapOf("key2" to 2, "key1" to 1, "key4" to 1, "key3" to 3)

        Log.i(TAG, "map is equal = ${numbersMap == anotherMap}")
    }

    private fun defaultMapIsLinkedHashMap() {
        Log.i(TAG, "_________________________________________________________")

        val numbersMap = mutableMapOf("one" to 1, "two" to 2)
        numbersMap["three"] = 3
        numbersMap["one"] = 11

        Log.i(TAG, "$numbersMap")
    }

    companion object {
        const val TAG = "MainActivity"
    }
}