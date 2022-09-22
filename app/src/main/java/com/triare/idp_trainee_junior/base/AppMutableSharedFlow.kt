package com.triare.idp_trainee_junior.base

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

fun <T> ReplayMutableSharedFlow(): MutableSharedFlow<T> {
    return MutableSharedFlow(
        replay = 1,
        extraBufferCapacity = 0,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
}