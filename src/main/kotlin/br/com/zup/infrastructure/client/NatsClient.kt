package br.com.zup.infrastructure.client

import br.com.zup.infrastructure.model.EventsInformation
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import javax.inject.Singleton

@NatsClient
@Singleton
interface NatsClient {
    @Subject("products")
    fun send(eventsInformation: EventsInformation)
}