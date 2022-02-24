package com.aula04.banco.banco.controller;

import com.aula04.banco.banco.dto.RequestCliente;
import com.aula04.banco.banco.dto.ResponseCliente;
import com.aula04.banco.banco.model.BancoCliente;
import com.aula04.banco.banco.model.Cliente;
import com.aula04.banco.banco.model.Conta;
import com.aula04.banco.banco.model.TipoConta;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.lang.ref.Cleaner;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    BancoCliente bancoCliente  = new BancoCliente();

    @GetMapping
    public List<ResponseCliente> clientes(Model model){
        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta(UUID.randomUUID(),12345,23, TipoConta.CONTA_CORRENTE));
        Cliente cliente = new Cliente(UUID.randomUUID(),"teste","teste1@gmail.com","0",contas);
        Cliente cliente2 = new Cliente(UUID.randomUUID(),"teste2","teste2@gmail.com","0",contas);

        bancoCliente.adicionar(cliente);
        bancoCliente.adicionar(cliente2);
        List<Cliente> clientes = bancoCliente.buscaClientes();
//        model.addAttribute("clientes",clientes);
        return ResponseCliente.toResponse(clientes);
    }
//    @GetMapping("/cadastro")
//    public String cadastrar(){
//        return "cadastroForm";
//    }

    @PostMapping
    public ResponseEntity<ResponseCliente> cadastraCliente(@RequestBody Cliente requestCliente, UriComponentsBuilder uriComponentsBuilder){
//        Cliente cliente = new Cliente(nome,email,agencia,conta );
//        bancoCliente.adicionar(cliente);

        Cliente cliente = new Cliente(UUID.randomUUID(),requestCliente.getNome(),requestCliente.getEmail(),requestCliente.getSenha(),requestCliente.getContas());
        bancoCliente.adicionar(cliente);
        URI uri = uriComponentsBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(ResponseCliente.toReponseIndividual(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseCliente> detalhesCliente(@PathVariable UUID id ) throws Exception {
        return ResponseEntity.ok( new ResponseCliente(bancoCliente.detalhesCliente(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseCliente> atualizaCliente(@PathVariable UUID id,@RequestBody RequestCliente requestCliente) throws Exception {
        return ResponseEntity.ok(new ResponseCliente(bancoCliente.atualizarCliente(id,requestCliente)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseCliente> removerCliente(@PathVariable UUID id) throws Exception{
        return ResponseEntity.ok(new ResponseCliente(bancoCliente.removerCliente(id)));
    }
}
