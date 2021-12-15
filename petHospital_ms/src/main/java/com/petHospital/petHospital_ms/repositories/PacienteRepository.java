package com.petHospital.petHospital_ms.repositories;
import com.petHospital.petHospital_ms.models.Paciente;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface PacienteRepository extends MongoRepository <Paciente, String> {}