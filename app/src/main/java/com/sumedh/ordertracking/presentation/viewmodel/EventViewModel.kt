package com.sumedh.ordertracking.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sumedh.ordertracking.common.Resource
import com.sumedh.ordertracking.domain.use_case.GetTrackingByNumberUseCase
import com.sumedh.ordertracking.presentation.EventResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class EventViewModel @Inject constructor(
    private val getTrackingByNumberUseCase: GetTrackingByNumberUseCase
) : ViewModel() {

    private val _eventResultState = mutableStateOf(EventResultState())
    val eventResultState: State<EventResultState> = _eventResultState

    init {
        getEvents()
    }

    private fun getEvents() {
        getTrackingByNumberUseCase.invoke().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _eventResultState.value = EventResultState(events = result.data?: emptyList())
                }

                is Resource.Error -> {
                    _eventResultState.value = EventResultState(error = result.message?:"An unexpected error occured")
                }

                is Resource.Loading -> {
                    _eventResultState.value = EventResultState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}