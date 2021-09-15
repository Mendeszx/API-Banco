package com.banco.api.model;

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

    public static List<ClienteDto> converter(List<Cliente> cliente){
        return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
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
