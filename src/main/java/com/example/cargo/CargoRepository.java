package com.example.cargo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
    List<Cargo> findByLoadNumber(String loadNumber);

    List<Cargo> findByRecipientNameAndRecipientPhone(String recipientName, String recipientPhone);
}
