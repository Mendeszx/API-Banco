package com.banco.api.service;

import com.banco.api.model.Cliente;
import com.banco.api.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    Repository repository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Cliente> cliente = repository.findByEmail(s);
        if (cliente.isPresent()){
            return cliente.get();
        }

        throw new UsernameNotFoundException("Dados inválidos!");
    }
}
