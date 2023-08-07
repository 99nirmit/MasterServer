package com.service.registry.serviceresgistry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer // this project will become server
class ServiceResgistryApplication

fun main(args: Array<String>) {
	runApplication<ServiceResgistryApplication>(*args)
}
