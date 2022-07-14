package com.gelson.helpdesk.repositories;

import com.gelson.helpdesk.domain.Cliente;
import com.gelson.helpdesk.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
