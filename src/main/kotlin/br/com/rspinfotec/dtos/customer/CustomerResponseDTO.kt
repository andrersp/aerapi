package br.com.rspinfotec.dtos.customer

import br.com.rspinfotec.entity.Customer
import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
data class CustomerResponseDTO(

    @Schema(example = "1")
    val id: Long,

    @Schema(example = "Full customer name")
    val name: String,

    @Schema(example = "01345678901")
    val phone: String,

    @Schema(example = "Free text about customer")
    val obs: String
) {
    companion object {
        fun fromEntity(client: Customer): CustomerResponseDTO =
            CustomerResponseDTO(
                id = client.id,
                name = client.name,
                phone = client.phone,
                obs = client.obs
            )
    }
}
