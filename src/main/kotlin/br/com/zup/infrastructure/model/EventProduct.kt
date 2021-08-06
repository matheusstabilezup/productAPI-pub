package br.com.zup.infrastructure.model

import java.math.BigDecimal
import java.util.UUID

data class EventProduct(
    var id: UUID? = null,
    val name: String = "",
    val category: String = "",
    val price: BigDecimal = BigDecimal.ZERO,
    val stock: Int = Int.MIN_VALUE
)
