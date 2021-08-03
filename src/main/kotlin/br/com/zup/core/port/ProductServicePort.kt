package br.com.zup.core.port

import br.com.zup.core.model.Product

interface ProductServicePort {

    fun create(product: Product): Product

}
