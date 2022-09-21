package com.triare.idp_trainee_junior

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.databinding.ActivityTaskTwoBinding

class TaskTwoActivity : AppCompatActivity() {
    private val binding: ActivityTaskTwoBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.action.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frContainer, TaskTwoFragment())
                .commit()
        }
    }
}