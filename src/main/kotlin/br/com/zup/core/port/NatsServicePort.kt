package br.com.zup.core.port

import br.com.zup.infrastructure.model.ProductEvent

interface NatsServicePort {

    fun sendNats(productEvent: ProductEvent): ProductEvent

}
