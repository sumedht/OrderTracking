package com.sumedh.stoxholdingapp.data.dto

import com.sumedh.ordertracking.domain.model.Data

data class DataDto(
    val trackings: List<TrackingDto>
)

fun DataDto.toData() : Data {
    return Data(
        trackings = trackings,
    )
}
