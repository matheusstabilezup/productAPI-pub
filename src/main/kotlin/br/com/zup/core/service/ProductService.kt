package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.model.Product
import br.com.zup.core.port.EventServicePort
import br.com.zup.core.port.ProductServicePort
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductService(private val eventServicePort: EventServicePort) : ProductServicePort {
    override fun create(product: Product) {
        eventServicePort.create(ProductConverter.toEventProduct(product))
    }

    override fun update(id: UUID, product: Product) {
        product.id = id
        eventServicePort.update(ProductConverter.toEventProduct(product))
    }

    override fun delete(id: UUID) {
        eventServicePort.delete(id)
    }
}
