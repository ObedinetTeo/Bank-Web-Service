package com.exim.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exim.client.entity.AdresaClientView;
import java.util.List;
import java.util.Optional;

@Repository
public interface AdresaClientRepository extends JpaRepository<AdresaClientView, Long>{
    List<AdresaClientView> findByAdresaActiva(Boolean adresaActiva);
    List<AdresaClientView> findByOras(String oras);
    List<AdresaClientView> findByTara(String tara);
    Optional<AdresaClientView> findByCodClient(String codClient);
}
