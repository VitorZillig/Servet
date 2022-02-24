package com.aula04.banco.banco.model;

import com.aula04.banco.banco.dto.RequestCliente;

import java.util.*;

public class BancoCliente {
    private static List<Cliente> clientes = new ArrayList<>();
    public void adicionar(Cliente cliente){
        BancoCliente.clientes.add(cliente);
    }

    public List<Cliente> buscaClientes(){
        return BancoCliente.clientes;
    }

    public Cliente detalhesCliente(UUID id) throws Exception{
        Optional<Cliente> resultClient = BancoCliente.clientes.stream().filter(cliente -> Objects.equals(cliente.getId(),id)).findAny();
        if(resultClient.isPresent()){
            return resultClient.get();
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }

    public Cliente atualizarCliente(UUID id, RequestCliente requestCliente) throws Exception {
        BancoCliente.clientes.stream().filter(cliente -> Objects.equals(cliente.getId(),id))
                .forEach(cliente -> {
                    cliente.setNome(requestCliente.getNome());
                    cliente.setEmail(requestCliente.getEmail());
                    cliente.setSenha(requestCliente.getSenha());
                });
        return detalhesCliente(id);
    }

    public Cliente removerCliente(UUID id) throws Exception{
        Cliente clienteDeletado = detalhesCliente(id);
        Optional<Cliente> novoBancoCliente =  BancoCliente.clientes.stream().filter(cliente -> !Objects.equals(cliente.getId(),id)).findFirst();
        BancoCliente.clientes.clear();
        novoBancoCliente.stream().forEach(cliente -> BancoCliente.clientes.add(cliente));
        return clienteDeletado;
    }
}
