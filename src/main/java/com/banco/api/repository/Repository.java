package com.banco.api.repository;

import com.banco.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Cliente,Long> {
}
