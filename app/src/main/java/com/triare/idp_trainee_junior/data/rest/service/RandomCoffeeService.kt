package com.triare.idp_trainee_junior.data.rest.service

import com.triare.idp_trainee_junior.data.rest.dto.RandomCoffeeResponseDto
import retrofit2.Response
import retrofit2.http.GET

interface RandomCoffeeService {
    @GET("random.json")
    suspend fun getRandomCoffee():Response<RandomCoffeeResponseDto>
}