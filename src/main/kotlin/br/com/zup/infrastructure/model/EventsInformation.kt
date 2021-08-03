package br.com.zup.infrastructure.model

data class EventsInformation(
    val event: Event = Event.SAVE_PRODUCT,
    val productEvent: ProductEvent = ProductEvent()
)
