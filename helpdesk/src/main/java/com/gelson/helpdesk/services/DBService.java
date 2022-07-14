package com.gelson.helpdesk.services;

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
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private ChamadoRepository chamadoRepository;

    public void instanciaDB() {
        Tecnico tec1 = new Tecnico(null,"Valdir Cesar", "63653230268","valdir@gmail.com","123");
        tec1.addPerfis(Perfil.ADMIN);

        Cliente cli1 = new Cliente(null, "Linus Touward", "8052795470", "torvard@gmail.com", "123");

        Chamado cha1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);


        tecnicoRepository.saveAll(Arrays.asList(tec1));
        clienteRepository.saveAll(Arrays.asList(cli1));
        chamadoRepository.saveAll(Arrays.asList(cha1));
    }
}
