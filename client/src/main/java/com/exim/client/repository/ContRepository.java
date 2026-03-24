package com.exim.client.repository;

import com.exim.client.entity.Cont;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.exim.client.model.TipCont;



@Repository
public interface ContRepository extends JpaRepository<Cont, Long>{
    List<Cont> findByIdClient(Long idClient);
    List<Cont> findByTipCont(TipCont tipCont);
    List<Cont> findByIdClientAndTipCont(Long idClient, TipCont tipCont);
    List<Cont> findByClientIdAndActiv(Long idClient, boolean stare_cont);
    boolean existsByIdClient(Long idClient);
}
