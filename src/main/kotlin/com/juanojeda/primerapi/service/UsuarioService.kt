package com.juanojeda.primerapi.service

import com.juanojeda.primerapi.dto.NuevoAlumno
import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.model.Usuario
import com.juanojeda.primerapi.repository.AlumnoRepository
import com.juanojeda.primerapi.repository.ProfesorRepository
import com.juanojeda.primerapi.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service

class UsuarioService {
    @Autowired
    lateinit var usuarioRepository: UsuarioRepository
    @Autowired
    lateinit var profesorRepository: ProfesorRepository



    fun list(): List<Usuario> {
        return usuarioRepository.findAll()
    }

    fun save(usuario: Usuario):Usuario{
        try {
            profesorRepository.findById(usuario.profesorId) ?: throw Exception("Id de profesor no existe")
            return usuarioRepository.save(usuario)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(usuario: Usuario): Usuario {
        try {
            usuarioRepository.findById(usuario.id) ?: throw Exception("El id ${usuario.id} el estudiante no existe")

            return usuarioRepository.save(usuario)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }

    fun updateName(usuario: Usuario):Usuario{

        val response= usuarioRepository.findById(usuario.id)
            ?:throw Exception()
        response.username=usuario.username


        return usuarioRepository.save(response)


    }

    fun delete (id:Long): Boolean{
        usuarioRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?):Usuario?{
        return usuarioRepository.findById(id)
    }

    fun getByAsistencias (asistencias: Long?): List<Usuario>?{
        return usuarioRepository.getListActiveAsistencias(asistencias)
    }

    @Transactional
    fun updateOtherName (NuevoAlumno: NuevoAlumno): String?{
        val rowsUpdate=usuarioRepository.setOtherName(NuevoAlumno.nombre, NuevoAlumno.nuevoAlumno)
        return "${rowsUpdate} rows updated"
    }


}