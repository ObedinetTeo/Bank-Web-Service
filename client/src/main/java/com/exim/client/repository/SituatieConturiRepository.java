package com.exim.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exim.client.entity.SituatieConturiView;

@Repository
public interface SituatieConturiRepository extends JpaRepository<SituatieConturiView, Long>{
    List<SituatieConturiView> findByCodClient(String codClient);
}
