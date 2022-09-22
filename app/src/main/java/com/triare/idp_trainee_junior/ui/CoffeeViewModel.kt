package com.triare.idp_trainee_junior.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.triare.idp_trainee_junior.base.ReplayMutableSharedFlow
import com.triare.idp_trainee_junior.data.repo.RandomCoffeeRepo
import com.triare.idp_trainee_junior.ui.dvo.RandomCoffeeResponseDvo
import com.triare.idp_trainee_junior.ui.dvo.state.LoadingState
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class CoffeeViewModel : ViewModel() {

    private val repo = RandomCoffeeRepo()

    private val _loadingState = ReplayMutableSharedFlow<LoadingState>()
    val loadingState = _loadingState.asSharedFlow()

    private val _url = ReplayMutableSharedFlow<RandomCoffeeResponseDvo?>()
    val url = _url.asSharedFlow()

    fun getRandomCoffeeUrl() {
        viewModelScope.launch {
            _loadingState.tryEmit(LoadingState(true))
            val result = repo.getRandomCoffee()

            if (result.isSuccess) {
                _url.tryEmit(result.getOrNull())
                _loadingState.tryEmit(LoadingState(false))
            }else {
                Log.e(TAG, "Something went wrong")
            }
        }
    }
    companion object{
        const val TAG = "CoffeeViewModel"
    }
}