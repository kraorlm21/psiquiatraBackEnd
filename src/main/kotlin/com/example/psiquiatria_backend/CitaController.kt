package com.example.psiquiatria_backend

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/citas")
class CitaController(private val repository: CitaRepository) {

    // 1. Obtener todas las citas
    @GetMapping
    fun obtenerTodas(): List<Cita> = repository.findAll()

    // 2. Agendar una nueva cita
    @PostMapping
    fun agendar(@RequestBody cita: Cita): Cita = repository.save(cita)

    // 3. Borrar una cita
    @DeleteMapping("/{id}")
    fun borrar(@PathVariable id: Long): ResponseEntity<Void> {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // 4. Actualizar cita (Opcional, por si quieres editar después)
    @PutMapping("/{id}")
    fun actualizar(@PathVariable id: Long, @RequestBody citaNueva: Cita): ResponseEntity<Cita> {
        return if (repository.existsById(id)) {
            val citaGuardada = repository.save(citaNueva.copy(id = id))
            ResponseEntity.ok(citaGuardada)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}