package br.com.infnet.aula01sbnoite.service;

import br.com.infnet.aula01sbnoite.model.Cliente;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {
    Logger logger = LoggerFactory.getLogger(ClienteService.class);
    List<Cliente> clientes = initClientes();
    private List<Cliente> initClientes() {
        logger.info("GET ALL CLIENTES");
        Cliente leonardo = new Cliente(0L, "Leonardo");
        Cliente pedro = new Cliente(1L, "Pedro");
        Cliente joao = new Cliente(2L, "Joao");
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(leonardo);
        clientes.add(pedro);
        clientes.add(joao);
        return clientes;
    }
    public List<Cliente> getAll(){
        return clientes;
    }
    public Cliente getById(int id){
        return clientes.get(id);
    }
    public void save(Cliente cliente){
        clientes.add(cliente);
    }
    public Cliente delete(int id){
        return clientes.remove(id);
    }
    public void update(int id, Cliente cliente){
        clientes.remove(id);
        cliente.setId((long)id);
        clientes.add(id,cliente);
    }
}
