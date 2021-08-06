package br.com.zup.entrypoint.controller

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.port.ProductServicePort
import br.com.zup.entrypoint.dto.ProductRequest
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.validation.Validated
import java.util.UUID
import javax.validation.Valid

@Controller("/v1/productAPIPub/products")
@Validated
class ProductController(private val productService: ProductServicePort) {
    @Post
    fun create(@Valid @Body request: ProductRequest) = productService.create(ProductConverter.toProduct(request))

    @Put("/{id}")
    fun update(@PathVariable id: UUID, @Valid @Body request: ProductRequest) =
        productService.update(id, ProductConverter.toProduct(request))

    @Delete("/{id}")
    fun delete(@PathVariable id: UUID) = productService.delete(id)
}