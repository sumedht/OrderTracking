package com.sumedh.stoxholdingapp.data.dto

import com.sumedh.ordertracking.domain.model.EventResponse

data class EventResponseDto(
    val `data`: DataDto
)

fun EventResponseDto.toEventResponse() : EventResponse {
    return EventResponse(
        data =  data,
    )
}