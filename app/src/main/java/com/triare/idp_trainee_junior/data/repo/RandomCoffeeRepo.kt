package com.triare.idp_trainee_junior.data.repo

import com.triare.idp_trainee_junior.data.rest.dto.toDvo
import com.triare.idp_trainee_junior.data.source.RandomCoffeeSource
import com.triare.idp_trainee_junior.ui.dvo.RandomCoffeeResponseDvo

class RandomCoffeeRepo {

    suspend fun getRandomCoffee(): Result<RandomCoffeeResponseDvo?> {

        val response = RandomCoffeeSource().getRandomCoffee()
        return if (response.isSuccessful) {
            Result.success(response.body()?.toDvo())
        } else {
            Result.failure(exception = Throwable("Something went wrong"))
        }
    }
}