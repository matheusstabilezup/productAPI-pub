package br.com.zup.core.port

import br.com.zup.core.model.Product
import java.util.UUID

interface ProductServicePort {
    fun create(product: Product)
    fun update(id: UUID, product: Product)
    fun delete(id: UUID)
}
