package br.com.zup.infrastructure.service

import br.com.zup.core.port.NatsServicePort
import br.com.zup.infrastructure.client.NatsClient
import br.com.zup.infrastructure.model.Event
import br.com.zup.infrastructure.model.EventsInformation
import br.com.zup.infrastructure.model.ProductEvent
import java.util.UUID
import javax.inject.Singleton

@Singleton
class NatsService(private val natsClient: NatsClient) : NatsServicePort {

    override fun sendNats(productEvent: ProductEvent): ProductEvent {

        productEvent.id = UUID.randomUUID()

        val eventInformation = EventsInformation(
            Event.SAVE_PRODUCT,
            productEvent
        )

        natsClient.send(eventInformation)

        return productEvent
    }
}