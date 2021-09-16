package com.banco.api.repository;

import com.banco.api.model.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface Repository extends JpaRepository<Cliente,Long> {
    Optional<Cliente> findByNumeroDaConta(int numeroDaConta);
    Page<Cliente> findByNome(String nome, Pageable paginacao);
    List<Cliente> findByCpf(String cpf);
    Optional<Cliente> findByEmail(String email);
}
