package com.juanojeda.primerapi.model

import javax.persistence.*

@Entity
@Table(name="profesor")

class Profesor {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id:Long?=null
    var nombre: String?=null
    var materia: String?=null
}