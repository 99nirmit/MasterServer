package com.example.apigateway.repository

import com.example.apigateway.domain.Regestration
import org.springframework.data.jpa.repository.JpaRepository

interface RegestrationRepository : JpaRepository<Regestration,Long>{

    fun findByEmail(email:String):Regestration?
}