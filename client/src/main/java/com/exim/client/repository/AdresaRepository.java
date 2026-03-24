package com.exim.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exim.client.entity.Adresa;
import com.exim.client.model.TipAdresa;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdresaRepository extends JpaRepository<Adresa, Long>{
    List<Adresa> findByIdClient(Long idClient);
    Optional<Adresa> findByIdClientAndTipAdresa(Long idClient, TipAdresa tipAdresa);
    long countByIdClient(Long idClient);
}
