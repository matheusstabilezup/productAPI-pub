package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.model.Product
import br.com.zup.core.port.NatsServicePort
import br.com.zup.core.port.ProductServicePort
import javax.inject.Singleton

@Singleton
class ProductService(private val natsService: NatsServicePort) : ProductServicePort {

    override fun create(product: Product) =
        ProductConverter.toProduct(natsService.sendNats(ProductConverter.toProductEvent(product)))


}
