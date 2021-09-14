package com.banco.api.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class ClienteForm {

    @NotNull @NotEmpty
    private String nome;

    private int numeroDaConta;

    @NotNull @NotEmpty
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Cliente converter(ClienteForm clienteForm){
        return new Cliente(nome,numeroDaConta,cpf);
    }
}
