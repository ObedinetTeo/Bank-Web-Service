package com.exim.client.repository;

import com.exim.client.entity.DetaliiClientView;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface DetaliiClientRepository extends JpaRepository<DetaliiClientView, String> {
    Optional<DetaliiClientView> findByCodClient(String codClient);
    Optional<DetaliiClientView> findByCnp(String cnp);
    Optional<DetaliiClientView> findByActId(String actId);
    List<DetaliiClientView> findByNumeContainingIgnoreCaseOrPrenumeContainingIgnoreCase(String nume, String prenume);
    List<DetaliiClientView> findByNumeContainingIgnoreCase(String nume);

    List<DetaliiClientView> findByTara(String tara);
}
