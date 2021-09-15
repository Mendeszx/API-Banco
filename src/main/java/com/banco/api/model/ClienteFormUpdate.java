package com.banco.api.model;

import com.banco.api.repository.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteFormUpdate {
    @NotNull
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private int numeroDaConta;

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

    public Cliente atualizar(Long id, Repository repository){
    Cliente cliente = repository.getOne(id);
    cliente.setNome(this.nome);
    cliente.setNumeroDaConta(this.numeroDaConta);

    return cliente;
    }

}
