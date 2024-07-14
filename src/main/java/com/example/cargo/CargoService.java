package com.example.cargo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo submitCargo(Cargo cargo) {
        cargo.setReceived(false);
        cargo.setSubmittedAt(LocalDateTime.now()); // Set the submission time
        return cargoRepository.save(cargo);
    }

    public Cargo markAsReceived(Long id, String receivedBy, String identificationNumber) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cargo not found"));
        cargo.setReceived(true);
        cargo.setReceivedBy(receivedBy);
        cargo.setIdentificationNumber(identificationNumber);
        cargo.setReceivedAt(LocalDateTime.now()); // Set the received time
        return cargoRepository.save(cargo);
    }

    public void deleteCargo(Long id) {
        Cargo cargo = cargoRepository.findById(id).orElseThrow(() -> new RuntimeException("Cargo not found"));
        cargoRepository.delete(cargo);
    }

    public List<Cargo> getAllCargo() {
        return cargoRepository.findAll();
    }
}
