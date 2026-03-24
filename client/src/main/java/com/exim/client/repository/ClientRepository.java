package com.exim.client.repository;

import com.exim.client.entity.Client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByCodClient(String codClient);
    Optional<Client> findByActId(String actId);
    List<Client> findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(String nume, String prenume);
    boolean existsByCodClient(String codClient);
    boolean existexistsByActId(String actId);
}
