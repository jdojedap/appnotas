package com.juanojeda.primerapi.model

import javax.persistence.*
@Entity
@Table(name = "alumno")

class Alumno {


        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Id
        @Column(updatable = false)
        var id : Long? = null
        var name : String? = null
        var materias: String? = null
        var asistencias: Long? = null
        var profesor_id:Long?=null



}