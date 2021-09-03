package com.banco.api.controller;

import com.banco.api.model.Cliente;
import com.banco.api.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController(value = "/api")
public class Controll {

    @Autowired
    Repository repository;

    @GetMapping("/cliente")
    public List<Cliente> listaDeClientes(){
        return repository.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Optional<Cliente> Cliente(@PathVariable(value = "id")long id){
        return repository.findById(id);
    }

    @PostMapping("/cliente")
    public Cliente salvaCliente(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @DeleteMapping("/cliente")
    public String deletaCliente(@RequestBody Cliente cliente){
        repository.delete(cliente);
        return "Cliente deletado com sucesso!";
    }

    @PutMapping("/cliente")
    public Cliente atualizaCliente(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }
}
