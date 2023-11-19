package br.com.rspinfotec.services

import br.com.rspinfotec.constants.CustomerConstants.CUSTOMERS
import br.com.rspinfotec.constants.CustomerConstants.CUSTOMER_1
import br.com.rspinfotec.constants.CustomerConstants.CUSTOMER_PAYLOAD
import br.com.rspinfotec.repository.CustomerRepository
import br.com.rspinfotec.services.customer.CustomerService
import br.com.rspinfotec.shared.exceptions.ApiException
import io.micronaut.test.annotation.MockBean
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

@MicronautTest
class CustomerServiceTest(
    private val customerService: CustomerService,
    private val customerRepository: CustomerRepository
) {

    @MockBean(CustomerRepository::class)
    fun customerRepository(): CustomerRepository =
        mock(CustomerRepository::class.java)


    @Test
    fun testCreateCustomerReturnSuccess() {
        `when`(customerRepository.save(CUSTOMER_1)).thenReturn(CUSTOMER_1)

        val sut = customerService.createCustomer(CUSTOMER_PAYLOAD)
        assertThat(sut.name).isEqualTo(CUSTOMER_1.name)
    }

    @Test
    fun testCreateCustomerReturnException() {
        `when`(customerRepository.findByPhone(CUSTOMER_1.phone)).thenReturn(CUSTOMER_1)
        assertThatThrownBy { customerService.createCustomer(CUSTOMER_PAYLOAD) }.isInstanceOf(ApiException::class.java)
    }

    @Test
    fun getAllCustomersReturnSuccess() {
        `when`(customerRepository.findAll()).thenReturn(CUSTOMERS)
        val sut = customerService.getAllCustomers()
        assertThat(sut).isNotEmpty
        assertThat(sut.first().name).isEqualTo(CUSTOMER_1.name)
    }

}