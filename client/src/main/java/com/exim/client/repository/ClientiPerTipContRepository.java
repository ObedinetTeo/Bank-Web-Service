package com.exim.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.exim.client.entity.ClientiPerTipContView;
import com.exim.client.model.TipCont;

@Repository
public interface ClientiPerTipContRepository extends JpaRepository<ClientiPerTipContView, Long> {
    List<ClientiPerTipContView> findByTipCont(TipCont tipCont);
}
