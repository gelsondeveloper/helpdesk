package com.gelson.helpdesk.repositories;

import com.gelson.helpdesk.domain.Cliente;
import com.gelson.helpdesk.domain.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
