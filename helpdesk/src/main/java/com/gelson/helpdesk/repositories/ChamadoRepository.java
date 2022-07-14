package com.gelson.helpdesk.repositories;

import com.gelson.helpdesk.domain.Chamado;
import com.gelson.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
