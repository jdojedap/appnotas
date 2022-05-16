package com.juanojeda.primerapi.service

import com.juanojeda.primerapi.model.Alumno
import com.juanojeda.primerapi.model.Representante
import com.juanojeda.primerapi.repository.RepresentanteRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.persistence.Id

@Service

class RepresentanteService {
    @Autowired
    lateinit var representanteRepository: RepresentanteRepository

    fun list():List<Representante>{
        return representanteRepository.findAll()
    }

    fun save (representante: Representante):Representante {
        return representanteRepository.save(representante)
    }
    fun update(representante: Representante): Representante {
        representanteRepository.findById(representante.id)

        return  representanteRepository.save(representante)
    }
    fun updateName(representante: Representante) {
        val response=representanteRepository.findById(representante.id)
            ?:throw Exception()
        response.nombre=representante.nombre

    }

    fun delete(id: Long): Boolean{
        representanteRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?): Representante?{
        return representanteRepository.findById(id)
    }

}