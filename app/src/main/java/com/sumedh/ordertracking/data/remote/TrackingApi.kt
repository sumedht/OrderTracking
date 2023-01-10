package com.sumedh.ordertracking.data.remote

import com.sumedh.stoxholdingapp.data.dto.EventResponseDto
import retrofit2.http.GET

interface TrackingApi {
    @GET("v1/trackers/7cbdffb3-db55-4998-a628-4c8e7e9c02d5/results")
    suspend fun getTracking() : EventResponseDto
}