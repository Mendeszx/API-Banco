package com.banco.api.model;

import java.util.List;
import java.util.stream.Collectors;

public class ClienteDto {
    private long id;
    private String nomeDoCliente;
    private int numeroDaConta;

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.nomeDoCliente = cliente.getNomeDoCliente();
        this.numeroDaConta = cliente.getNumeroDaConta();
    }

    public static List<ClienteDto> converter(List<Cliente> cliente){
        return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public long getId() {
        return id;
    }

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }
}
