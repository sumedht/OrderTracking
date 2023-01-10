package com.sumedh.ordertracking.domain.repository

import com.sumedh.stoxholdingapp.data.dto.EventDto

interface TrackingRepository {
    suspend fun getTracking() : List<EventDto>
}