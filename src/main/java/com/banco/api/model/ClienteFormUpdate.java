package com.banco.api.model;

import com.banco.api.repository.Repository;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClienteFormUpdate {
    @NotNull
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private int numeroDaConta;

    @NotBlank(message = "Senha é obrigatório")
    private String senha;

    @NotBlank(message = "Email é obrigatório")
    private String email;

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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente atualizar(Long id, Repository repository){
        Cliente cliente = repository.getOne(id);
        cliente.setNome(this.nome);
        cliente.setNumeroDaConta(this.numeroDaConta);
        cliente.setSenha(this.senha);
        cliente.setEmail(this.email);
        return cliente;
    }

}
