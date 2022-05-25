package com.juanojeda.primerapi.service

import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.repository.AlumnoRepository
import com.juanojeda.primerapi.repository.ProfesorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.server.ResponseStatusException


@Service


class AlumnoService {
    @Autowired
    lateinit var alumnoRepository: AlumnoRepository
    @Autowired
    lateinit var profesorRepository: ProfesorRepository



    fun list(): List<Alumno> {
        return alumnoRepository.findAll()
    }

    fun save(alumno: Alumno):Alumno{
        try {
            profesorRepository.findById(alumno.profesorId) ?: throw Exception("Id de profesor no existe")
            return alumnoRepository.save(alumno)
        }catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun update(alumno: Alumno): Alumno {
        try {
            alumnoRepository.findById(alumno.id) ?: throw Exception("El id ${alumno.id} el estudiante no existe")

            return alumnoRepository.save(alumno)
        }
        catch (ex:Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND,ex.message,ex)
        }
    }

    fun updateName(alumno: Alumno):Alumno{

      val response= alumnoRepository.findById(alumno.id)
              ?:throw Exception()
        response.name=alumno.name


        return alumnoRepository.save(response)


    }

    fun delete (id:Long): Boolean{
        alumnoRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?):Alumno?{
        return alumnoRepository.findById(id)
    }


}