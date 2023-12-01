package br.com.infnet.aula01sbnoite.controllers;

import br.com.infnet.aula01sbnoite.model.Cliente;
import br.com.infnet.aula01sbnoite.service.ClienteService;
import jakarta.websocket.server.PathParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    Logger logger = LoggerFactory.getLogger(ClienteController.class);
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

    @GetMapping
    public List<Cliente> getAll(){
        logger.info("GET ALL CLIENTES");
        return clienteService.getAll();
    }
    @GetMapping("/{id}")
    public Cliente getById(@PathVariable int id){
        logger.info("GET CLIENTE: " + id);
        return clienteService.getById(id);

    }
    //@RequestMapping(name = "salvar cliente", method = GET)
    @PostMapping
    public void save(@RequestBody Cliente cliente){
        logger.info("CREATE CLIENTE: " + cliente);
        clienteService.save(cliente);

    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        logger.info("DELETE CLIENTE " + id);
        Cliente removed = clienteService.delete(id);
        logger.info("CLIENTE DELETADO: " + removed);

    }
    @PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody  Cliente cliente){
        logger.info("UPDATE CLIENTE: " + id + " novo cliente: " +cliente );
        clienteService.update(id,cliente);
    }

}
