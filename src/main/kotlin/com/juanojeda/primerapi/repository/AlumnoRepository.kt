package com.juanojeda.primerapi.repository

import com.juanojeda.primerapi.model.Alumno
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface AlumnoRepository: JpaRepository<Alumno,Long> {
    fun findById(id:Long?):Alumno?


    @Query(nativeQuery = true)
    fun getListActiveAsistencias (@Param("asistencias") asistencias:Long?) : List<Alumno>?

    @Modifying
    @Query(nativeQuery=true)
    fun setOtherName (@Param("name")  name:String?, @Param("newName")  newName:String?) : Integer?


}
