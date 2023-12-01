package br.com.infnet.aula01sbnoite.controllers;

import br.com.infnet.aula01sbnoite.model.Cliente;
import br.com.infnet.aula01sbnoite.model.Telefone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HelloWorldController {
    Logger logger = LoggerFactory.getLogger(HelloWorldController.class);
    @GetMapping("/hello")
    public List<Cliente> hello(){
        logger.info("Metodo Hello");
        List<String> lista = List.of("Leonardo", "Jose", "Pedro");
        Map<String, String> map = Map.of("Leonardo", "O+", "Pedro", "AB-", "Jose", "O-");
        Telefone telefone = new Telefone("+55", "21", "27178097", "residencial");
       // Cliente cliente = new Cliente(1L, "Leonardo Gloria", "11133344455",telefone);
       // Cliente cliente2 = new Cliente(3L, "Pedro", "11133344455",telefone);
        //Cliente cliente3 = new Cliente(4L, "Marcelo", "11133344455",telefone);
        //List<Cliente> clientes = List.of(cliente, cliente2, cliente3);

        return null;
    }
    @GetMapping("/hello2")
    public String hello2(@RequestParam(required = false, defaultValue = "default value") String nome){
        nome = nome.toUpperCase();
        return nome;

        /* Com Optional
        String nomeValue = nome.orElse("default value");

        nomeValue= nomeValue.toUpperCase();
        logger.info("Hello 2");
        logger.info("Nome: " + nome);
        return nomeValue;

         */
    }
    @GetMapping("/hello3")
    public String hello3(@RequestParam String nome, @RequestParam double size){
        logger.info("Nome: " + nome);
        logger.info("size: " + size);
        size = Math.pow(size,2);
        return nome + " " + size;
    }
    @GetMapping("/potencia")
    public double potencia(@RequestParam(required = true) double numero,
                           @RequestParam(required = false, defaultValue = "2") int potencia){
        logger.info("Inicio do Metodo: ");
        int potencia2 ;

        try{
            potencia2 = Integer.valueOf("fdfa");
            logger.info("Potencia2: "+ potencia2);

        }catch (NumberFormatException ex){
            potencia2= 2;
            logger.info("Potencia2: "+ potencia2);
        }
        double resultado = Math.pow(numero, potencia);
        return resultado;
    }
    @GetMapping("/potenciaList")
    public List<Double> potencia(@RequestParam  List<Double> lista,
                                 @RequestParam(required = false, defaultValue = "2") int potencia){
        logger.info("lista " + lista.toString());
        List<Double> list = lista.stream().map(numero -> Math.pow(numero, potencia)).toList();
        return list;
    }
    @GetMapping("/variosParams")
    public void varios(@RequestParam Map<String,String> allParams){
        logger.info("Params: " + allParams.toString());
        boolean param1 = allParams.containsKey("param1");
    }

}
