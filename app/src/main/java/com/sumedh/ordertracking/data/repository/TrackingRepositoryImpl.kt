package com.sumedh.ordertracking.data.repository

import android.util.Log
import com.sumedh.ordertracking.data.remote.TrackingApi
import com.sumedh.ordertracking.domain.repository.TrackingRepository
import com.sumedh.stoxholdingapp.data.dto.EventDto
import javax.inject.Inject

class TrackingRepositoryImpl @Inject constructor(
    private val api: TrackingApi
) : TrackingRepository{
    private var events : List<EventDto> = emptyList()

    override suspend fun getTracking(): List<EventDto> {
        val response = api.getTracking()
        events = response.data.trackings[0].events
        return events
    }
}