package com.gelson.helpdesk;

import com.gelson.helpdesk.domain.Chamado;
import com.gelson.helpdesk.domain.Cliente;
import com.gelson.helpdesk.domain.Tecnico;
import com.gelson.helpdesk.domain.enums.Perfil;
import com.gelson.helpdesk.domain.enums.Prioridade;
import com.gelson.helpdesk.domain.enums.Status;
import com.gelson.helpdesk.repositories.ChamadoRepository;
import com.gelson.helpdesk.repositories.ClienteRepository;
import com.gelson.helpdesk.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class HelpdeskApplication  {


	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}


}
