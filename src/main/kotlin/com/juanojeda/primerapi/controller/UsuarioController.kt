package com.juanojeda.primerapi.controller

import com.juanojeda.primerapi.dto.NuevoAlumno
import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.model.Usuario
import com.juanojeda.primerapi.service.AlumnoService
import com.juanojeda.primerapi.service.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")

class UsuarioController {

    @Autowired
    lateinit var usuarioService: UsuarioService

    @GetMapping

    fun List(): List<Usuario> {
        return  usuarioService.list()
    }
    @GetMapping("/asistencias/{asistencias}")
    fun listByAsistencias (@PathVariable("asistencias") asistencias: Long): List<Usuario>? {
        return usuarioService.getByAsistencias(asistencias)
    }

    @PostMapping
    fun save (@RequestBody usuario: Usuario): Usuario {
        return  usuarioService.save(usuario)
    }

    @PostMapping("/change/name")
    fun updateOtherName (@RequestBody nuevoAlumno: NuevoAlumno): String?{
        return usuarioService.updateOtherName(nuevoAlumno)
    }
    @PutMapping
    fun update (@RequestBody usuario: Usuario): Usuario{
        return usuarioService.update(usuario)

    }

    @PatchMapping
    fun updateName(@RequestBody usuario: Usuario): Usuario {
        return usuarioService.updateName(usuario)

    }

    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long): Boolean{
        return usuarioService.delete(id )
    }

    @GetMapping("/{id}")
    fun listById (@PathVariable("id") id: Long): Usuario?{
        return usuarioService.getById(id)
    }
}