package com.teste.tarefa3.controller;


import com.teste.tarefa3.model.eventomodel;
import com.teste.tarefa3.repository.eventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class eventoController {
    @Autowired
    eventoRepository repository;

    @GetMapping(path = "/ev/{IDEVENTO}")
    public ResponseEntity consultar(@PathVariable("IDEVENTO") Integer idevento) {
        return repository.findById(idevento)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    /* @PostMapping(path="/api/usario/salvar")*/
   /*@RequestMapping(
           value = "/api/usario/salvar",
           produces = "application/json",
           method = {RequestMethod.GET, RequestMethod.POST})*/

    @PostMapping(path = "/ev/salvar")
    public eventomodel salvar(@RequestBody eventomodel idevento) {
        return repository.save(idevento);
    }

    eventoController(eventoRepository eventoRepository) {
        this.repository = eventoRepository;
    }

    //Listar Todos Os Eventos
    @CrossOrigin
    @GetMapping(path = "/ev/todos")
    public Iterable<eventomodel> findAll() {
        return repository.findAll();
    }


    @DeleteMapping(path = "/ev-deletar/{IDEVENTO}")
    public ResponseEntity<Integer> deletar(@PathVariable("IDEVENTO") Integer idevento) {
        repository.deleteById(idevento);
        return ResponseEntity.ok().body(idevento);
    }



/*
    @Controller
    // @Component
    public class eventojsp {
        @RequestMapping("/evento")
        public String eventos() {
            System.out.println("evventos Bem vindo");
            return "evento.jsp";
        }
    }
*/

 /*
    @RestController
    public class HomeController {

       @RequestMapping("/webpages/")
        public String home(){
            Iterable<eventomodel> a= findAll();
            eventomodel e= (eventomodel) a;
            System.out.println(a);
            System.out.println(e);
           // b = a.iterator();
            return String.valueOf(e.toString1());
        }
    }*/


    @GetMapping(value = "/maxidev")
    public ResponseEntity<Integer> searchByidevento() {
        Integer result = repository.searchByidevento();
        System.out.println();
        System.out.println();
        return ResponseEntity.ok(result);
    }

    @RestController
    public class HomeController {

        @RequestMapping("/testeee")
        public String home() {
            return "<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "<style>" +
                    "h1{color:red;}" +
                    "</style>" +
                    "</head>\n" +
                    "<body>\n" +
                    "<body>\n" +

                    "<input type=\"button\" onclick=\"ParseJson();\" value=\"Chama parse\" >\n" +
                    "<div class=\"container\">\n" +
                    "<ul id=\"tasks\"  style = list-style:none;>\n" +
                    "<li>EVENTOS!</li>\n" +
                    "</ul>\n" +
                    "</div>\n" +
                    "<input type=\"button\" onclick=\"ParseJson1();\" value=\"Chama parse1\" >\n" +

                    "<input type=\"button\" onclick=\"chamarJson();\" value=\"Chama json\" >\n" +


                    "<script type=\"text/javascript\">\n" +
                    "function chamarJson() {\n" +

                    "const request = new XMLHttpRequest();\n" +

                    "request.open('GET', 'http://localhost:8080/ev/todos')\n" +

                    "request.onload = function () {\n" +
                    "console.log(JSON.parse(this.responseText))\n" +
                    "}\n" +

                    "request.onerror = function () {\n" +
                    "console.log('erro ao executar a requisição')\n" +
                    "}\n" +

                    "request.send();\n" +
                    "}\n" +

                    "function ParseJson1(){\n" +
                    "var text1 ='[{\"idevento\":1,\"nome\":\"SEM.Instituto de Matemática Pura e Aplicada\",\"sigla\":\"IMPA\",\"areadeconcentracao\":\"matemática\",\"instituicaoorganizadora\":\"IMPA\"},{\"idevento\":2,\"nome\":\"SEM. Dep. Econ Puc-Rio\",\"sigla\":\"ECO\",\"areadeconcentracao\":\"Economia\",\"instituicaoorganizadora\":\"Puc-Rio\"},{\"idevento\":3,\"nome\":\"SEM. ACAD. Instituto de Computação-UFF\",\"sigla\":\"IC-UFF\",\"areadeconcentracao\":\"Computação\",\"instituicaoorganizadora\":\"UFF\"},{\"idevento\":4,\"nome\":\"Portões Abertos Semana do Aviador\",\"sigla\":\"ITA\",\"areadeconcentracao\":\"Ciências Aeronáuticas\",\"instituicaoorganizadora\":\"Instituto Tecnológico da Aeronautica\"}]';\n" +
                    //console.log(text1);
                    "var JsonObject = JSON.parse(text1);\n" +
                    // var texto1 = JsonObject.idevento;
                    //superHeroes['members'][1]['powers'][2]
                    "var count = Object.keys(JsonObject).length;\n" +
                    //var count=4;
                    //var taskn=1;
                    "for(i=0;i<=count;i++){" +
                    "var eventos = \"ID:                  \" + JsonObject[i].idevento + \" NOME:                  \" + JsonObject[i].nome + \" SIGLA:                  \" + JsonObject[i].sigla + \" AREA DE CONCENTRAÇÃO:                  \" + JsonObject[i].areadeconcentracao + \" INSTITUIÇÃO ORGANIZADORA:                  \" + JsonObject[i].instituicaoorganizadora;\n" +
                    "var p = document.createElement(\"li\");\n" +
                    "var node = document.createTextNode(eventos);\n" +
                    "p.appendChild(node);\n" +
                    //var texto = obj.employees[i].firstName + " " + obj.employees[i].lastName;
                    "var z = document.getElementById(\"tasks\");\n" +
                    //document.getElementById("tasks").append(eventos);
                    "z.appendChild(p);\n" +
                    "}\n" +

                    "}\n" +

                    "</script>\n" +
                    "</body>\n" +
                    "</html>\n";
        }


    }
}





