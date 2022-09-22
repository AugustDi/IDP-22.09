package com.triare.idp_trainee_junior.data.rest.dto

import com.google.gson.annotations.SerializedName
import com.triare.idp_trainee_junior.base.const.StringConst.EMPTY_STRING
import com.triare.idp_trainee_junior.ui.dvo.RandomCoffeeResponseDvo

data class RandomCoffeeResponseDto(
    @SerializedName("file")
    val url: String?
)

fun RandomCoffeeResponseDto.toDvo(): RandomCoffeeResponseDvo {
    return RandomCoffeeResponseDvo(
        url = url ?: EMPTY_STRING
    )
}