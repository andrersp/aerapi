package br.com.rspinfotec.constants

import br.com.rspinfotec.dtos.customer.CustomerRequestDTO
import br.com.rspinfotec.entity.Customer

object CustomerConstants {

    val CUSTOMER_PAYLOAD = CustomerRequestDTO(
        name = "client test",
        phone = "012345678901",
        obs = ""
    )

    val CUSTOMER_1 = Customer(
        id = 1L,
        name = "client test",
        phone = "012345678901",
        obs = ""
    )

    val CUSTOMERS = listOf(CUSTOMER_1)


}