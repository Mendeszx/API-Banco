package com.banco.api.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ClienteForm {

    @NotNull @NotEmpty
    private String nomeDoCliente;

    private int numeroDaConta;

    public String getNomeDoCliente() {
        return nomeDoCliente;
    }

    public void setNomeDoCliente(String nomeDoCliente) {
        this.nomeDoCliente = nomeDoCliente;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public Cliente converter(ClienteForm clienteForm){
        return new Cliente(nomeDoCliente,numeroDaConta);
    }
}
