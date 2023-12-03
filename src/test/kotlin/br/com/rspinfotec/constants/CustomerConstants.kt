package br.com.rspinfotec.constants

import br.com.rspinfotec.domain.Customer
import br.com.rspinfotec.dtos.customer.CustomerRequestDTO

object CustomerConstants {

    val CUSTOMER_PAYLOAD = CustomerRequestDTO(
        name = "Customer 1",
        phone = "012345678901",
        obs = ""
    )

    val CUSTOMER_1 = Customer(
        id = 1L,
        name = "Customer 1",
        phone = "012345678901",
        obs = ""
    )

    val CUSTOMER_2 = Customer(
        id = 2L,
        name = "Customer 2",
        phone = "1234567890",
        obs = ""
    )

    val CUSTOMERS = listOf(CUSTOMER_1, CUSTOMER_2)


}