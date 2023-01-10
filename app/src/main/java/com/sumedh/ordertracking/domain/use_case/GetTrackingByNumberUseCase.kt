package com.sumedh.ordertracking.domain.use_case

import android.util.Log
import com.sumedh.ordertracking.common.Resource
import com.sumedh.ordertracking.domain.model.Event
import com.sumedh.ordertracking.domain.repository.TrackingRepository
import com.sumedh.stoxholdingapp.data.dto.toEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTrackingByNumberUseCase @Inject constructor(
    private val repository: TrackingRepository
){

     fun invoke() : Flow<Resource<List<Event>>> = flow {
        try {
            emit(Resource.Loading())
            //response.error?.let { emit(Resource.Error(response.error.toString())) }
            val events = repository.getTracking().map { it.toEvent() }
            emit(Resource.Success(events))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage?:"An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connectivity"))
        }
    }
}