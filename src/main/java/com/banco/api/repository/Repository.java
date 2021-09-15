package com.banco.api.repository;

import com.banco.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByNumeroDaConta(int numeroDaConta);
    List<Cliente> findByNome(String nome);
    List<Cliente> findByCpf(String cpf);
}
