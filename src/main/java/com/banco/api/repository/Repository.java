package com.banco.api.repository;

import com.banco.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Cliente,Long> {
    List<Cliente> findByNumeroDaConta(int numeroDaConta);
    List<Cliente> findByNomeDoCliente(String nomeDoCliente);
}
