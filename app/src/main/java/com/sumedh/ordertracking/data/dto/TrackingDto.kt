package com.sumedh.stoxholdingapp.data.dto

import com.sumedh.ordertracking.domain.model.Tracking

data class TrackingDto(
    val events: List<EventDto>
)

fun TrackingDto.toTracking() : Tracking {
    return Tracking(
        events =  events,
    )
}