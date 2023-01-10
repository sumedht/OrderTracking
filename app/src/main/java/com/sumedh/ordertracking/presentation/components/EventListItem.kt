package com.sumedh.ordertracking.presentation.components

import android.os.Build
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.sumedh.ordertracking.common.Utils
import com.sumedh.ordertracking.domain.model.Event

@Composable
fun EventListItem(
    event : Event
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),
    ) {

            Text(
                text = event.status,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = Utils.getReadableDate(event.datetime),
                modifier = Modifier.padding(vertical = 8.dp),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.body1,
                overflow = TextOverflow.Ellipsis
            )
    }
}