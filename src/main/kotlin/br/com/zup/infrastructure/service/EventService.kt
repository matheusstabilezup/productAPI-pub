package br.com.zup.infrastructure.service

import br.com.zup.core.port.EventServicePort
import br.com.zup.infrastructure.client.EventClient
import br.com.zup.infrastructure.model.Event
import br.com.zup.infrastructure.model.EventProduct
import br.com.zup.infrastructure.model.EventType
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID
import javax.inject.Singleton

@Singleton
class EventService(private val eventClient: EventClient) : EventServicePort {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun create(eventProduct: EventProduct) {
        val event = Event(EventType.SAVE_PRODUCT, eventProduct)
        eventClient.send(event)
        logger.info("Event sent to broker: $event")
    }

    override fun update(eventProduct: EventProduct) {
        val event = Event(EventType.UPDATE_PRODUCT, eventProduct)
        eventClient.send(event)
        logger.info("Event sent to broker: $event")
    }

    override fun delete(id: UUID) {
        val event = Event(EventType.DELETE_PRODUCT, EventProduct(id))
        eventClient.send(event)
        logger.info("Event sent to broker: $event")
    }
}