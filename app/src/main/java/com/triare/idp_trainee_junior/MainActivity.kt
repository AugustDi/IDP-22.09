package com.triare.idp_trainee_junior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        taskFirst()
    }

    private fun taskFirst() {
        //Use keywords val and var.
        // val -> Immutable (read-only) local variables are defined using the val keyword. They can only be assigned a value once.
        val immutableX: Int = 1
        val immutableY = 1
        Log.d("Task 1", "immutableX = $immutableX")
        Log.d("Task 1", "immutableY = $immutableY")

        //var -> Mutable variables are declared using the var keyword.
        var mutableX: String = "for example"
        Log.d("Task 1", "mutableX = $mutableX")

        mutableX = "something else"
        Log.d("Task 1", "immutableX = $mutableX")

        //Use nullable and non-nullable variables.
        val nullableX: Int? = null // nullable variable
        val nonNullableX: Int = 123
        //Use functions with and without data return.
        withReturn()
        Log.d("Task 1", "functions with return: return = ${withoutReturn()} ")
        withoutReturn()
    }

    private fun withReturn(): Int {
        return 3
    }

    private fun withoutReturn(): Unit {
        Log.d("Task 1", ": Unit is unnecessary ")
    }
}