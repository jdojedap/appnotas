package com.juanojeda.primerapi.controller

import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.model.Profesor
import com.juanojeda.primerapi.service.ProfesorService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/profesor")



class ProfesorController {
    @Autowired
    lateinit var profesorService: ProfesorService

    @GetMapping
    fun list(): List<Profesor>{
        return profesorService.list()
    }
    @PostMapping
    fun save (@RequestBody profesor: Profesor): Profesor{
        return profesorService.save(profesor)
    }
   @PutMapping
    fun update (@RequestBody profesor: Profesor):Profesor{
        return profesorService.update(profesor)


   }
    @PatchMapping
    fun updateName(@RequestBody profesor: Profesor): Profesor{
        return profesorService.updateName(profesor)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return profesorService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Profesor?{
        return profesorService.getById(id)
    }

}