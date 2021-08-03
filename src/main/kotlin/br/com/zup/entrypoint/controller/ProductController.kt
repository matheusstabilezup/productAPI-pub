package br.com.zup.entrypoint.controller

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.port.ProductServicePort
import br.com.zup.entrypoint.dto.ProductRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.validation.Valid

@Controller("/v1/productAPIPub/products")
@Validated
class ProductController(private val productService: ProductServicePort) {

    @Post
    fun create(@Valid @Body request: ProductRequest) =
        HttpResponse.created(ProductConverter.toResponse(productService.create(ProductConverter.toProduct(request))))

}