package br.com.zup.core.mapper

import br.com.zup.core.model.Product
import br.com.zup.entrypoint.dto.ProductRequest
import br.com.zup.entrypoint.dto.ProductResponse
import br.com.zup.infrastructure.model.ProductEvent
import java.util.UUID

class ProductConverter {
    companion object {
        fun toProduct(request: ProductRequest) =
            Product(null, request.name, request.category, request.price, request.stock)

        fun toProduct(productEvent: ProductEvent) = Product(
            productEvent.id,
            productEvent.name,
            productEvent.category,
            productEvent.price,
            productEvent.stock
        )

        fun toResponse(product: Product) =
            ProductResponse(product.id, product.name, product.category, product.price, product.stock)

        fun toProductEvent(product: Product) =
            ProductEvent(product.id, product.name, product.category, product.price, product.stock)

        fun toEvent(id: UUID, product: Product) =
            ProductEvent(id, product.name, product.category, product.price, product.stock)

        fun toProductList(productEventList: List<ProductEvent>) = productEventList.map { toProduct(it) }

        fun toResponseList(productList: List<Product>) = productList.map { toResponse(it) }

    }
}


