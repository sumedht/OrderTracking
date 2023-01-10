package com.sumedh.ordertracking.presentation.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.R
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sumedh.ordertracking.presentation.viewmodel.EventViewModel

@Composable
fun TrackingScreen(
    viewModel: EventViewModel = hiltViewModel()
) {
    val eventResultState = viewModel.eventResultState.value

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                contentColor = Color.White,
                title = {
                    Text(text = "Order Tracking")
                },
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                LazyColumn(modifier = Modifier
                    .fillMaxWidth()
                ) {
                    items(eventResultState.events) { event ->
                        EventListItem(event = event)
                        Divider(color = Color.LightGray,
                            modifier = Modifier.padding(horizontal = 20.dp)
                        )
                    }
                }

                Spacer(modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.0f)
                    .background(Color.LightGray)
                )
            }
            if (eventResultState.error.isNotBlank() || eventResultState.error.isNotBlank()) {
                Toast.makeText(LocalContext.current, eventResultState.error, Toast.LENGTH_LONG).show()
            }

            if (eventResultState.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }

}