package com.juanojeda.primerapi.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AlumnoServiceTest {

    @Autowired
    lateinit var alumnoService: AlumnoService

    @Test
    fun validateNuiIsValid(){
        val response =  alumnoService.validateSerialNumber("7554930579")
        Assertions.assertEquals(true,response)
    }

    @Test
    fun validateNuiIsInvalid(){
        val response =  alumnoService.validateSerialNumber("7554930579")
        Assertions.assertEquals(false,response)
    }

    @Test
    fun validateNuiIsBlank(){
        Assertions.assertThrows(Exception::class.java) {
            val response = alumnoService.validateSerialNumber("")

        }
    }

    @Test
    fun validateSerialIsincomplete(){
        Assertions.assertThrows(Exception::class.java) {
            val response = alumnoService.validateSerialNumber("345")

        }
    }

}