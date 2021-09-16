package com.banco.api.model;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class ClienteForm {

    @NotNull @NotBlank(message = "Nome é obrigatório")
    private String nome;

    private int numeroDaConta;

    @NotNull @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    @NotNull @NotBlank(message = "Senha é obrigatório")
    private String senha;

    @NotNull @NotBlank(message = "Email é obrigatório")
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Cliente converter(ClienteForm clienteForm){
        return new Cliente(nome,numeroDaConta,cpf,senha,email);
    }
}
