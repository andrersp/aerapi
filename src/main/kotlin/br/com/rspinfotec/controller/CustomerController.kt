package br.com.rspinfotec.controller

import br.com.rspinfotec.dtos.customer.CustomerRequestDTO
import br.com.rspinfotec.dtos.customer.CustomerResponseDTO
import br.com.rspinfotec.services.customer.CustomerService
import br.com.rspinfotec.shared.exceptions.ApiErrorMessage
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import jakarta.validation.Valid

@Controller("/customer")
@Tag(name = "Customer")
@ApiResponse(responseCode = "400", content = [Content(schema = Schema(implementation = ApiErrorMessage::class))])
@Validated
class CustomerController(
    private val customerService: CustomerService
) {

    @Get
    @Operation(summary = "Get customers", description = "List all customers")
    fun list(): List<CustomerResponseDTO> = customerService.getAllCustomers()

    @Post
    @Operation(summary = "Create customer", description = "create a new customer")
    @Status(HttpStatus.CREATED)
    fun createCustomer(@Valid @Body payload: CustomerRequestDTO) = customerService.createCustomer(payload)

    @Get("/{customerId}")
    @Operation(summary = "Customer detail", description = "Get customer detail by id")
    fun getById(@PathVariable customerId: Long): CustomerResponseDTO = customerService.getById(customerId)
}