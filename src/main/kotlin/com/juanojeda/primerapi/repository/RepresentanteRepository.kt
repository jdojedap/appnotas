package com.juanojeda.primerapi.repository

import com.juanojeda.primerapi.model.Representante
import org.springframework.data.jpa.repository.JpaRepository

interface RepresentanteRepository: JpaRepository<Representante,Long> {


    fun findById(id:Long?):Representante?
}