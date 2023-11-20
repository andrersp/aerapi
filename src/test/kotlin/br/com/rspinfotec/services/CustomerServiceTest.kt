package br.com.rspinfotec.services

import br.com.rspinfotec.constants.CustomerConstants.CUSTOMERS
import br.com.rspinfotec.constants.CustomerConstants.CUSTOMER_1
import br.com.rspinfotec.constants.CustomerConstants.CUSTOMER_2
import br.com.rspinfotec.constants.CustomerConstants.CUSTOMER_PAYLOAD
import br.com.rspinfotec.dtos.customer.CustomerRequestDTO
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
import java.util.*


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

    @Test
    fun getCustomerDetailReturnSuccess() {
        `when`(customerRepository.findById(CUSTOMER_1.id)).thenReturn(Optional.of(CUSTOMER_1))
        val sut = customerService.getById(1L)
        assertThat(sut.name).isEqualTo(CUSTOMER_1.name)
    }

    @Test
    fun getCustomerDetailReturnException() {
        `when`(customerRepository.findById(1L)).thenReturn(Optional.empty())
        assertThatThrownBy { customerService.getById(1L) }.isInstanceOf(ApiException::class.java)
    }

    @Test
    fun testEditCustomerReturnSuccess() {
        `when`(customerRepository.findById(CUSTOMER_2.id)).thenReturn(Optional.of(CUSTOMER_2))

        val payload = CustomerRequestDTO(
            name = "new name",
            phone = "22999999999",
            obs = ""
        )
        val sut = customerService.editCustomer(2L, payload)
        assertThat(sut.name).isEqualTo(payload.name)

    }

    @Test
    fun testEditCustomerReturnExceptionDuplicatePhone() {
        `when`(customerRepository.findById(CUSTOMER_2.id)).thenReturn(Optional.of(CUSTOMER_2))
        `when`(customerRepository.findByPhone(CUSTOMER_1.phone)).thenReturn(CUSTOMER_1)

        val payload = CustomerRequestDTO(
            name = "new name",
            phone = CUSTOMER_1.phone,
            obs = ""
        )
        assertThatThrownBy { customerService.editCustomer(2L, payload) }.isInstanceOf(ApiException::class.java)


    }

}