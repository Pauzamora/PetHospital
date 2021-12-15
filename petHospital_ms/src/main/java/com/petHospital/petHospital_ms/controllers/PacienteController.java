package com.petHospital.petHospital_ms.controllers;

import com.petHospital.petHospital_ms.exceptions.PacienteNotFoundException;
import com.petHospital.petHospital_ms.models.Paciente;
import com.petHospital.petHospital_ms.repositories.PacienteRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class PacienteController {

    private final PacienteRepository pacienteRepository;
    public PacienteController(PacienteRepository pacienteRepository) {

        this.pacienteRepository = pacienteRepository;
    }

    @GetMapping("/pacientes/{nombre}")
    Paciente getPaciente(@PathVariable String nombre){
        return pacienteRepository.findById(nombre)
                .orElseThrow(() -> new PacienteNotFoundException("No se encontro un paciente con el nombre: "
                        + nombre));
    }
    @PostMapping("/pacientes")
    Paciente newPaciente(@RequestBody Paciente paciente){
        return pacienteRepository.save(paciente);

    }
    @PutMapping("/actualizarpaciente")
    Paciente updatePaciente(@RequestBody Paciente paciente){
        return pacienteRepository.save(paciente);
    }

    @DeleteMapping("/borrarpaciente/{nombre}")
    void
    delPaciente(@PathVariable String nombre) {pacienteRepository.deleteById(nombre);}


}
