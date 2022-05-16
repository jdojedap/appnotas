package com.juanojeda.primerapi.repository

import com.juanojeda.primerapi.model.Profesor
import org.springframework.data.jpa.repository.JpaRepository

interface ProfesorRepository:JpaRepository<Profesor,Long> {
    fun findById(id:Long?):Profesor?
}

