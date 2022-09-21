package com.triare.idp_trainee_junior

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        createTextView()
        createEditText()
        createButton()
        createImageButton()
        createToggleButton()
        addProgress()
        addRadioButton()
        addCheckBox()
        showActivityTwo()
    }

    private fun showActivityTwo() {
        createButton().text = "go to Activity Two"
        createButton().setOnClickListener{
            val intent = Intent(this, TaskTwoActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createTextView() {
        val textView = TextView(this)
        textView.text = TEST_STR
        textView.gravity = Gravity.CENTER_HORIZONTAL
        binding.root.addView(textView)

    }

    private fun createEditText() {
        val editText = EditText(this)
        editText.hint = "some hint"
        binding.root.addView(editText)
    }

    private fun createButton(): Button {
        val button = Button(this)
        button.text = "for example"
        button.setBackgroundColor(Color.CYAN)
        binding.root.addView(button)
        return button
    }

    private fun createImageButton() {
        val imageButton = ImageButton(this)
        imageButton.setImageResource(R.drawable.ic_baseline_android_24)
        binding.root.addView(imageButton)
    }

    private fun createToggleButton() {
        val toggleButton = ToggleButton(this)
        toggleButton.textOff = "OFF"
        toggleButton.textOn = "ON"
        toggleButton.isChecked = true
        binding.root.addView(toggleButton)
    }

    private fun addProgress() {
        val progress = ProgressBar(this)
        binding.root.addView(progress)
    }

    private fun addRadioButton() {
        val rb = RadioButton(this)
        rb.text = "Radio Button"
        rb.isChecked = true
        binding.root.addView(rb)
    }


    private fun addCheckBox() {
        val checkBox = CheckBox(this)
        checkBox.text = "check box"
        checkBox.isChecked = true
        binding.root.addView(checkBox)
    }

    companion object {
        const val TEST_STR = "test string"
    }
}