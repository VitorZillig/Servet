package com.aula04.banco.banco.service;

import com.aula04.banco.banco.BancoAula04Application;
import com.aula04.banco.banco.dto.RequestDeposito;
import com.aula04.banco.banco.model.BancoCliente;
import com.aula04.banco.banco.model.Cliente;
import com.aula04.banco.banco.model.Conta;
import com.aula04.banco.banco.model.TipoConta;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class OperacoesServiceTest {
    OperacoesService operacoesService = new OperacoesService();

    @Test
    public void deveChecarOValorTotal() throws Exception {

        List<Conta> listaContasTeste = new List<Conta>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Conta> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Conta conta) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Conta> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Conta> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Conta get(int index) {
                return null;
            }

            @Override
            public Conta set(int index, Conta element) {
                return null;
            }

            @Override
            public void add(int index, Conta element) {

            }

            @Override
            public Conta remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Conta> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Conta> listIterator(int index) {
                return null;
            }

            @Override
            public List<Conta> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        listaContasTeste.add(new Conta(UUID.randomUUID(),123,123, TipoConta.CONTA_CORRENTE,100.0));
        BancoAula04Application.bancoCliente.adiciona(new Cliente(UUID.randomUUID(), "teste", "teste@teste.com", "1234",listaContasTeste));

        UUID idClienteTeste = BancoAula04Application.bancoCliente.buscaClientes().get(0).getId();
        Double valorAnterior = BancoAula04Application.bancoCliente.detalhesCliente(idClienteTeste).getContas().get(0).getSaldo();
        RequestDeposito requestDeposito = new RequestDeposito();
        requestDeposito.setValor(100.0);
        UUID idContaTeste = BancoAula04Application.bancoCliente.detalhesCliente(idClienteTeste).getContas().get(0).getId();
        requestDeposito.setConta(idContaTeste);
        operacoesService.depositar(idClienteTeste, requestDeposito);
        Double novoValor = BancoAula04Application.bancoCliente.detalhesCliente(idClienteTeste).getContas().get(0).getSaldo();
        Assertions.assertTrue(valorAnterior!=novoValor);
        Assertions.assertEquals(novoValor-valorAnterior,requestDeposito.getValor());
    }
}
