package com.juanojeda.primerapi.controller

import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.model.Representante
import com.juanojeda.primerapi.service.RepresentanteService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.Collections.list

@RestController
@RequestMapping("/representante")

class RepresentanteController {
    @Autowired
    lateinit var representanteService: RepresentanteService
    @GetMapping

    fun List(): List<Representante>{
        return representanteService.list()

    }
    @PostMapping
    fun save (@RequestBody representante: Representante) {
        representanteService.save(representante)
    }

    @PutMapping
    fun update (@RequestBody representante: Representante): Representante{
        return representanteService.update(representante)
    }
    @PatchMapping
    fun updateName( @RequestBody representante: Representante) {
        return  representanteService.updateName(representante)
    }
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return representanteService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Representante?{
        return representanteService.getById(id)
    }






}