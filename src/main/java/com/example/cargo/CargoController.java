package com.example.cargo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @PostMapping("/submit")
    public ResponseEntity<Cargo> submitCargo(@RequestBody Cargo cargo) {
        try {
            cargo.setReceived(false);
            cargo.setSubmittedAt(LocalDateTime.now()); // Set the submission time
            var savedCargo = cargoService.submitCargo(cargo);
            return ResponseEntity.ok(savedCargo);
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/markAsReceived")
    public ResponseEntity<Cargo> markAsReceived(
        @RequestParam Long id, 
        @RequestParam String receivedBy, 
        @RequestParam String identificationNumber
    ) {
        try {
            Cargo updatedCargo = cargoService.markAsReceived(id, receivedBy, identificationNumber);
            return ResponseEntity.ok(updatedCargo);
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCargo(@PathVariable Long id) {
        try {
            cargoService.deleteCargo(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace(); // Print stack trace for debugging
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/all")
    public List<Cargo> getAllCargo() {
        return cargoService.getAllCargo();
    }
}
