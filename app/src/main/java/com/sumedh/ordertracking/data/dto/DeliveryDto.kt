package com.sumedh.stoxholdingapp.data.dto

import com.sumedh.ordertracking.domain.model.Data
import com.sumedh.ordertracking.domain.model.Delivery

data class DeliveryDto(
    val estimatedDeliveryDate: Any,
    val service: Any,
    val signedBy: String
)

fun DeliveryDto.toDelivery() : Delivery {
    return Delivery(
        estimatedDeliveryDate = estimatedDeliveryDate,
        service = service,
        signedBy = signedBy
    )
}