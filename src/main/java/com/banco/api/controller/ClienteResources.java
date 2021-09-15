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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
    public Page<ClienteDto> listaDeClientes(@RequestParam(required = false) String nome, @PageableDefault(sort = "id", direction = Sort.Direction.ASC) Pageable paginacao){

        if (nome == null){
            Page<Cliente> clientes = repository.findAll(paginacao);
            return ClienteDto.converter(clientes);
        }
        else
        {
            Page<Cliente> clientes = repository.findByNome(nome, paginacao);
            return ClienteDto.converter(clientes);
        }
    }

    @GetMapping("/cliente/{numeroDaConta}")
    @ApiOperation(value = "Retorna um cliente específico pelo número da conta")
    public ResponseEntity<ClienteDto> Cliente(@PathVariable(value = "numeroDaConta")int numeroDaConta){
        Optional<Cliente> optional = repository.findByNumeroDaConta(numeroDaConta);
        if (optional.isPresent()){
            return ResponseEntity.ok(new ClienteDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
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
        Optional<Cliente> optional = repository.findById(id);
        if (optional.isPresent()){
            Cliente cliente = clienteFormUpdate.atualizar(id, repository);
            return ResponseEntity.ok(new ClienteDto(cliente));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/cliente/{id}")
    @ApiOperation(value = "Deleta um cliente por Id")
    public ResponseEntity<?> deletaCliente(@PathVariable Long id){
        Optional<Cliente> optional = repository.findById(id);
        if (optional.isPresent()){
            repository.deleteById(id);
            return ResponseEntity.ok(new ClienteDto(optional.get()));
        }
        return ResponseEntity.notFound().build();
    }
}
