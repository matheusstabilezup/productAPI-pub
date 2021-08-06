package br.com.zup.infrastructure.client

import br.com.zup.infrastructure.model.Event

interface EventClient {
    fun send(event: Event)
}