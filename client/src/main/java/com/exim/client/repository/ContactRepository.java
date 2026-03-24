package com.exim.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exim.client.entity.Contact;
import java.util.List;
import java.util.Optional;


@Repository
public interface ContactRepository  extends JpaRepository<Contact, Long>{
    Optional<Contact> findByIdClient(Long idClient);
    Optional<Contact> findByTelMobil(String telMobil);
    List<Contact> findAllByStatusTrue();
    boolean existsByEmail(String email);
    boolean existsByTelMobil(String telMobil);
}

