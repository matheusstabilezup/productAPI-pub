package br.com.zup.infrastructure.model

data class Event(
    val eventType: EventType = EventType.SAVE_PRODUCT,
    val eventProduct: EventProduct = EventProduct()
)
