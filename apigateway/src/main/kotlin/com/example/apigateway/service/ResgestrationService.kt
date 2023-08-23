package com.example.apigateway.service

import com.example.apigateway.domain.Regestration
import com.example.apigateway.repository.RegestrationRepository
import org.springframework.stereotype.Service

@Service
class ResgestrationService (private val regestrationRepository: RegestrationRepository){

    fun createUser(regestration: Regestration):Regestration{
        return regestrationRepository.save(regestration)
    }

    fun getUserById(regestrationId: Long):Regestration?{
        return regestrationRepository.findById(regestrationId).orElse(null)
    }

    fun getUserByEmail(email: String):Regestration?{
        return regestrationRepository.findByEmail(email)
    }

    fun updateUser(regestration: Regestration):Regestration{
        return regestrationRepository.save(regestration)
    }

    fun deleteUser(regestrationId:Long){
        regestrationRepository.deleteById(regestrationId)
    }
}
