package br.com.zup.core.port

import br.com.zup.infrastructure.model.EventProduct
import java.util.UUID

interface EventServicePort {
    fun create(eventProduct: EventProduct)
    fun update(eventProduct: EventProduct)
    fun delete(id: UUID)
}