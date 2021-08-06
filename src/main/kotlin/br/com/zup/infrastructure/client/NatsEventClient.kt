package br.com.zup.infrastructure.client

import br.com.zup.infrastructure.model.Event
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject

@NatsClient
interface NatsEventClient : EventClient {
    @Subject("products")
    override fun send(event: Event)
}