package com.juanojeda.primerapi.controller

import com.juanojeda.primerapi.dto.NuevoAlumno
import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.service.AlumnoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/alumno")

class AlumnoController {
    @Autowired
    lateinit var alumnoService: AlumnoService

    @GetMapping

            fun List(): List<Alumno> {
                return  alumnoService.list()
    }
    @GetMapping("/asistencias/{asistencias}")
    fun listByAsistencias (@PathVariable("asistencias") asistencias: Long): List<Alumno>? {
        return alumnoService.getByAsistencias(asistencias)
    }

    @PostMapping
    fun save (@RequestBody alumno: Alumno): Alumno {
        return  alumnoService.save(alumno)
    }

    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody nuevoAlumno: NuevoAlumno): String?{
        return alumnoService.updateOtherName(nuevoAlumno)
    }
    @PutMapping
    fun update (@RequestBody alumno: Alumno): Alumno {
        return alumnoService.update(alumno)

    }

    @PatchMapping
    fun updateName(@RequestBody alumno: Alumno): Alumno {
        return alumnoService.updateName(alumno)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return alumnoService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Alumno?{
        return alumnoService.getById(id)
    }





}