package com.example.apigateway.domain

import jakarta.persistence.*
import jakarta.validation.constraints.Email

@Entity
@Table
data class Regestration (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    val email: String,
    val password: String
)