package com.banco.api.controller;

import com.banco.api.model.Cliente;
import com.banco.api.model.ClienteDto;
import com.banco.api.repository.Repository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Banco")
@CrossOrigin(origins = "*")
public class ClienteResources {

    @Autowired
    Repository repository;

    @GetMapping("/cliente")
    @ApiOperation(value = "Retorna uma lista de clientes")
    public List<ClienteDto> listaDeClientes(String nomeDoCliente){
        if (nomeDoCliente == null){
            return ClienteDto.converter(repository.findAll());
        }
        else
        {
            return ClienteDto.converter(repository.findByNomeDoCliente(nomeDoCliente));
        }
    }

    @GetMapping("/cliente/{numeroDaConta}")
    @ApiOperation(value = "Retorna um cliente específico pelo número da conta")
    public List<ClienteDto> Cliente(@PathVariable(value = "numeroDaConta")int numeroDaConta){
        System.out.println(numeroDaConta);
        return ClienteDto.converter(repository.findByNumeroDaConta(numeroDaConta));
    }

    @PostMapping("/cliente")
    @ApiOperation(value = "Salva um novo cliente no Banco")
    public Cliente salvaCliente(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }

    @DeleteMapping("/cliente")
    @ApiOperation(value = "Deleta um cliente no Banco")
    public String deletaCliente(@RequestBody Cliente cliente){
        repository.delete(cliente);
        return "Cliente deletado com sucesso!";
    }

    @PutMapping("/cliente")
    @ApiOperation(value = "Atualiza um cliente no Banco")
    public Cliente atualizaCliente(@RequestBody Cliente cliente){
        return repository.save(cliente);
    }
}
