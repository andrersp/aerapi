package br.com.rspinfotec.services.customer

import br.com.rspinfotec.dtos.customer.CustomerRequestDTO
import br.com.rspinfotec.dtos.customer.CustomerResponseDTO

interface CustomerService {
    fun createCustomer(payload: CustomerRequestDTO): CustomerResponseDTO
    abstract fun getAllCustomers(): List<CustomerResponseDTO>
}