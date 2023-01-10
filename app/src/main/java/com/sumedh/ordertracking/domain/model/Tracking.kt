package com.sumedh.ordertracking.domain.model

import com.sumedh.stoxholdingapp.data.dto.EventDto

data class Tracking(
    val events: List<EventDto>
)