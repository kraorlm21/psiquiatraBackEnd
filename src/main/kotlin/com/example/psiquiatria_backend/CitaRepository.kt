package com.example.psiquiatria_backend

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CitaRepository : JpaRepository<Cita, Long>