package com.triare.idp_trainee_junior.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.databinding.FragmentRandomCoffeBinding

class RandomCoffeeFragment : Fragment() {

    private val binding: FragmentRandomCoffeBinding by viewBinding(CreateMethod.INFLATE)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    companion object {
        fun newInstance() = RandomCoffeeFragment()
    }
}