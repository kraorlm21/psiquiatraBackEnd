package com.example.psiquiatria_backend

import jakarta.persistence.*

@Entity
@Table(name = "citas")
data class Cita(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0, // En Backend usamos Long, en Android Int (ojo con esto después)
    
    var nombrePaciente: String = "",
    var fecha: String = "", // Guardamos como String YYYY-MM-DD
    var hora: String = "",  // Guardamos como String HH:MM
    var motivo: String = ""
)