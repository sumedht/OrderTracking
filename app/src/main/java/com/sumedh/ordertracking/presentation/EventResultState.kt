package com.sumedh.ordertracking.presentation

import com.sumedh.ordertracking.domain.model.Event

data class EventResultState (
    val isLoading: Boolean = false,
    val events: List<Event> = emptyList(),
    val error: String = ""
)