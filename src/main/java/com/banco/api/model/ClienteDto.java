package com.banco.api.model;

import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto {
    private long id;
    private String nome;
    private int numeroDaConta;

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.numeroDaConta = cliente.getNumeroDaConta();
    }

    public static Page<ClienteDto> converter(Page<Cliente> cliente){
        return cliente.map(ClienteDto::new);
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

}
