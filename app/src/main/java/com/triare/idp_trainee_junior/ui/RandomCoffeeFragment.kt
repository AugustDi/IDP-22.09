package com.triare.idp_trainee_junior.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.CreateMethod
import by.kirich1409.viewbindingdelegate.viewBinding
import com.triare.idp_trainee_junior.databinding.FragmentRandomCoffeBinding
import com.triare.idp_trainee_junior.extensions.load
import com.triare.idp_trainee_junior.ui.dvo.RandomCoffeeResponseDvo
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class RandomCoffeeFragment : Fragment() {

    private val binding: FragmentRandomCoffeBinding by viewBinding(CreateMethod.INFLATE)
    private val vm: CoffeeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeUi()
        initUi()
    }

    private fun subscribeUi() {
        vm.loadingState.onEach {
            Log.d(TAG, "LoadingState: $it")
            showProgress(it.isLoading)
        }.launchIn(lifecycleScope)
    }

    private fun showProgress(isLoading: Boolean) {
        binding.progress.visibility = if (isLoading) VISIBLE else GONE
    }

    private fun initUi() {
        observeCoffeeUrl()
        initAction()
    }

    private fun observeCoffeeUrl() {
        vm.url.onEach {
            loadCoffee(it?.url)
            if (it?.url.isNullOrBlank()) showEmptyView(true) else showEmptyView(false)
            Log.d(TAG, "URL:${it?.url}")
        }.launchIn(lifecycleScope)
    }

    private fun initAction() {
        binding.action.setOnClickListener {
            vm.getRandomCoffeeUrl()
        }
    }

    private fun showEmptyView(isVisible: Boolean) {
        binding.emptyView.visibility = if (isVisible) VISIBLE else GONE
        binding.image.visibility = if (!isVisible) VISIBLE else GONE
        Log.wtf(TAG, "just for example: $isVisible")
        Log.i(TAG, "Empty view is shown: $isVisible")
    }

    private fun loadCoffee(url: String?) {
        binding.image.load(url)
        Log.i(TAG, "url: $url")
        Log.w(TAG, "url can by null mb")
    }

    companion object {
        fun newInstance() = RandomCoffeeFragment()
        const val TAG = "RandomCoffeeFragment"
    }
}