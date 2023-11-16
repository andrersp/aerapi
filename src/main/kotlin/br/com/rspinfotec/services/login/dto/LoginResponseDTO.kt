package br.com.rspinfotec.services.login.dto

import io.micronaut.serde.annotation.Serdeable
import io.swagger.v3.oas.annotations.media.Schema

@Serdeable
data class LoginResponseDTO(
    @Schema(example = "username")
    val userName: String,
    @Schema(example = "Bearer")
    val tokenType: String = "Bearer",
    @Schema(example = "iLCJpZCI6MTB9.8NmwhbVCwhRL52LCbL5KIwmIdLtkHd0iXKPT1yQi8BU")
    val accessToken: String
)
