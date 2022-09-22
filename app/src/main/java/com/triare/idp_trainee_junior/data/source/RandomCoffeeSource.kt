package com.triare.idp_trainee_junior.data.source

import com.triare.idp_trainee_junior.data.rest.Rest
import com.triare.idp_trainee_junior.data.rest.dto.RandomCoffeeResponseDto
import retrofit2.Response

class RandomCoffeeSource {
    suspend fun getRandomCoffee(): Response<RandomCoffeeResponseDto> {
        return Rest.randomCoffeeService.getRandomCoffee()
    }
}