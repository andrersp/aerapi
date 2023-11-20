package br.com.rspinfotec.services.customer

import br.com.rspinfotec.dtos.customer.CustomerRequestDTO
import br.com.rspinfotec.dtos.customer.CustomerResponseDTO

interface CustomerService {
    fun createCustomer(payload: CustomerRequestDTO): CustomerResponseDTO
    fun getAllCustomers(): List<CustomerResponseDTO>
    fun getById(customerId: Long): CustomerResponseDTO
    fun editCustomer(customerId: Long, payload: CustomerRequestDTO): CustomerResponseDTO
}