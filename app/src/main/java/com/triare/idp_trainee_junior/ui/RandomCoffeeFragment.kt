package com.triare.idp_trainee_junior.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.databinding.FragmentRandomCoffeBinding

class RandomCoffeeFragment : Fragment() {

    private val binding: FragmentRandomCoffeBinding by viewBinding(CreateMethod.INFLATE)
    private val vm: CoffeeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
    companion object {
        fun newInstance() = RandomCoffeeFragment()
    }
}