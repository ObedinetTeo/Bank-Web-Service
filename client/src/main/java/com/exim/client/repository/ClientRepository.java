package com.exim.client.repository;

import com.exim.client.entity.Client;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{
    Optional<Client> findByCodClient(String codClient);
    Optional<Client> findByIdClient(Long idClient);
    List<Client> findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(String nume, String prenume);
    List<Client> findByNumeContainingIgnoreCase(String nume);
    List<Client> findByStatus(Boolean status);
    @Query("SELECT MAX(c.codClient) FROM Client c")
    String findMaxCodClient();
    boolean existsByCnp(String cnp);
    boolean existsByActId(String actId);
}
