package br.com.zup.core.mapper

import br.com.zup.core.model.Product
import br.com.zup.entrypoint.dto.ProductRequest
import br.com.zup.infrastructure.model.EventProduct

class ProductConverter {
    companion object {
        fun toProduct(request: ProductRequest) =
            Product(null, request.name, request.category, request.price, request.stock)

        fun toEventProduct(product: Product) =
            EventProduct(product.id, product.name, product.category, product.price, product.stock)
    }
}


