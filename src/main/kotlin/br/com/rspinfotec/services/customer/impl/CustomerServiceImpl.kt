package br.com.rspinfotec.services.customer.impl

import br.com.rspinfotec.dtos.customer.CustomerRequestDTO
import br.com.rspinfotec.dtos.customer.CustomerResponseDTO
import br.com.rspinfotec.entity.Customer
import br.com.rspinfotec.repository.CustomerRepository
import br.com.rspinfotec.services.customer.CustomerService
import br.com.rspinfotec.shared.exceptions.ApiError
import br.com.rspinfotec.shared.exceptions.ApiException
import jakarta.inject.Singleton

@Singleton
class CustomerServiceImpl(
    private val customerRepository: CustomerRepository
) : CustomerService {
    override fun createCustomer(payload: CustomerRequestDTO): CustomerResponseDTO {
        val existingClient = customerRepository.findByPhone(payload.phone)
        if (existingClient != null) throw ApiException(
            ApiError.DUPLICATE_REGISTRY,
            "telephone number for another customer"
        )

        val customer = Customer(name = payload.name, phone = payload.phone, obs = payload.obs)
        customerRepository.save(customer)
        return CustomerResponseDTO.fromEntity(customer)
    }

    override fun getAllCustomers(): List<CustomerResponseDTO> {
        val customers = customerRepository.findAll()
        return customers.map { CustomerResponseDTO.fromEntity(it) }
    }


}