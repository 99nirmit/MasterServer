package com.example.apigateway.api

import com.example.apigateway.domain.Regestration
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.apigateway.service.ResgestrationService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import java.net.URI

@RestController
@RequestMapping("api/registration")
class RegestrationApi(private val regestrationService:ResgestrationService) {

    @PostMapping("/create-user")
    fun createUser(@RequestBody regestration:Regestration): ResponseEntity<Unit>{
        val createdUser = regestrationService.createUser(regestration)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/{email}")
    fun getUserByEmail(@PathVariable email:String):ResponseEntity<Regestration>{
        val user = regestrationService.getUserByEmail(email)
        return if(user != null){
            ResponseEntity.ok(user)
        }else{
            ResponseEntity.notFound().build()
        }
    }

    @PutMapping("/{registrationId}")
    fun updateUser(@PathVariable regestrationId:Long,@RequestBody regestration: Regestration): ResponseEntity<Regestration>{
        val existingUser = regestrationService.getUserById(regestrationId)
        return if(existingUser != null){
            val updatedUser = existingUser.copy(email = regestration.email, password = regestration.password)
            regestrationService.updateUser(updatedUser)
            ResponseEntity.ok(updatedUser)
        }else{
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id:Long): ResponseEntity<Unit>{
        val existingUser = regestrationService.getUserById(id)
        return if (existingUser != null){
            regestrationService.deleteUser(id)
            ResponseEntity.noContent().build()
        }else{
            ResponseEntity.notFound().build()
        }
    }
}