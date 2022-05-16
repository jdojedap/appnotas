package com.juanojeda.primerapi.service

import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.model.Profesor
import com.juanojeda.primerapi.repository.ProfesorRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service

class ProfesorService {
    @Autowired
    lateinit var profesorRepository: ProfesorRepository

    fun list(): List<Profesor> {
        return profesorRepository.findAll()
    }

    fun save (profesor: Profesor):Profesor {

        return profesorRepository.save(profesor)
        }

    fun update(profesor: Profesor): Profesor {
        profesorRepository.findById(profesor.id) ?: throw Exception()

        return  profesorRepository.save(profesor)

    }

    fun updateName(profesor: Profesor): Profesor {

        val  response= profesorRepository.findById(profesor.id)
            ?:throw Exception()
        response.id=profesor.id

        return profesorRepository.save(response)

    }

    fun delete (id:Long): Boolean{
        profesorRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?): Profesor?{
        return profesorRepository.findById(id)
    }


}