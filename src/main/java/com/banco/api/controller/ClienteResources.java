package com.banco.api.controller;

import com.banco.api.model.Cliente;
import com.banco.api.model.ClienteDto;
import com.banco.api.model.ClienteForm;
import com.banco.api.model.ClienteFormUpdate;
import com.banco.api.repository.Repository;
import com.banco.api.service.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api")
@Api(value = "API REST Banco")
@CrossOrigin(origins = "*")
public class ClienteResources {

    @Autowired
    Repository repository;

    @Autowired
    ApiService service;

    @GetMapping("/cliente")
    @ApiOperation(value = "Retorna uma lista de clientes")
    public List<ClienteDto> listaDeClientes(String nome){
        if (nome == null){
            return ClienteDto.converter(repository.findAll());
        }
        else
        {
            return ClienteDto.converter(repository.findByNome(nome));
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
    public ResponseEntity<ClienteDto> salvaCliente(@RequestBody @Valid ClienteForm clienteForm, UriComponentsBuilder uriComponentsBuilder){
        Cliente cliente = clienteForm.converter(clienteForm);
        repository.save(cliente);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

    @PutMapping("/cliente/{id}")
    @Transactional
    @ApiOperation(value = "Atualiza um cliente no Banco")
    public ResponseEntity<ClienteDto> atualizaCliente(@PathVariable Long id,  @RequestBody @Valid ClienteFormUpdate clienteFormUpdate){
        Cliente cliente = clienteFormUpdate.atualizar(id, repository);

        return ResponseEntity.ok(new ClienteDto(cliente));
    }

    @DeleteMapping("/cliente/{id}")
    @ApiOperation(value = "Deleta um cliente no Banco")
    public String deletaCliente(@PathVariable Long id){
        repository.deleteById(id);
        ResponseEntity.ok().build();
        return "Cliente deletado com sucesso!";
    }
}
