package com.teste.tarefa3.controller;

import com.teste.tarefa3.model.edicaoModel;
import com.teste.tarefa3.repository.edicaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin //importante para app local permitir o front enviar e recuperar os JSON  quando o html não está no servidor
@RestController
public class edicaoController {
    @Autowired
    edicaoRepository repository;

    @GetMapping(path = "/ed/{IDEDICAO}")
    public ResponseEntity consultar(@PathVariable("IDEDICAO") Integer idedicao) {
        return repository.findById(idedicao)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    /* @PostMapping(path="/api/usario/salvar")*/
   /*@RequestMapping(
           value = "/api/usario/salvar",
           produces = "application/json",
           method = {RequestMethod.GET, RequestMethod.POST})*/

    @PostMapping(path = "/ed/salvar")
    public edicaoModel salvar(@RequestBody edicaoModel idedicao) {
        return repository.save(idedicao);
    }


    edicaoController(edicaoRepository edicaoRepository) {
        this.repository = edicaoRepository;
    }

    @GetMapping(path = "/ed/todos")
    public Iterable<edicaoModel> findAll() {
        return repository.findAll();
    }
//deletar by ID
//@GetMapping(path = "/ed/{IDEDICAO}")
//public ResponseEntity consultar(@PathVariable("IDEDICAO") Integer idedicao) {
//    return repository.findById(idedicao);


    @DeleteMapping(path = "/ed-deletar/{IDEDICAO}")
    public ResponseEntity<Integer> deletar(@PathVariable("IDEDICAO") Integer idedicao){
        repository.deleteById(idedicao);
        return  ResponseEntity.ok().body(idedicao);}


    /*
        @GetMapping(value = "/cidade/{cidade}")
        public ResponseEntity<List<eventomodel>> searchBycidade(@PathVariable("cidade") String cidade) {
            List<eventomodel> result = repository.findBycidade(cidade);
            return ResponseEntity.ok(result);
    */
    @GetMapping(value = "/search-cidade")
    public ResponseEntity<List<edicaoModel>> searchByCidade(@RequestParam(value = "cidade", required = false, defaultValue = "") String cidade) {
        System.out.println(cidade);
        List<edicaoModel> result = repository.searchByCidade(cidade);
        return ResponseEntity.ok(result);
    }


    @GetMapping(value = "/search-data")
    public ResponseEntity<List<edicaoModel>> searchByData(@RequestParam(value = "min", required = false, defaultValue = "0") Double min, @RequestParam(value = "max", required = false, defaultValue = "1000000000000") Double max) {
        List<edicaoModel> result = repository.searchByData(min, max);
        return ResponseEntity.ok(result);
    }


    //@GetMapping(value = "/search-idEvento")
    //public ResponseEntity<List<edicaoModel>> searchByID(@RequestParam(value = "fkidevento", required = false) Integer fkidevento) {
    //    List<edicaoModel> result = repository.searchByID(fkidevento);
    //    return ResponseEntity.ok(result);
   // }

    @GetMapping(value = "/search-datacidade")
    public ResponseEntity<List<edicaoModel>> searchByDataCidade(@RequestParam(value = "min", required = false, defaultValue = "0") Double min, @RequestParam(value = "cidade", required = false, defaultValue = "") String cidade) {
    List<edicaoModel> result = repository.searchByDataCidade(min, cidade);
    System.out.println(min);
    System.out.println(cidade);
    return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/maxided")
    public ResponseEntity<Integer> searchByidedicao() {
        Integer result = repository.searchByidedicao();
        System.out.println();
        System.out.println();
        return ResponseEntity.ok(result);
    }



    //update
    //@PutMapping("/employees/{id}")
    /*@RequestMapping(method = RequestMethod.PUT,value = "updateEdi/{id}")
    public void  update(@RequestBody edicaoModel edicaoModel, Integer idedicao){
        repository.(idedicao);

        //return ResponseEntity.ok(updatedEmployee);
    }*/
/*
    @PutMapping("/employees/{IDEDICAO}")
    public void updateUser(edicaoModel e) {
        edicaoRepository repository;
        edicaoModel edicaoModel = repository.findById("id");
        // crush the variables of the object found
        userFromDb.setFirstname("john");
        userFromDb.setLastname("dew");
        userFromDb.setAge(16);
        userRepository.save(userFromDb);
    }


    public ResponseEntity consultar(@PathVariable("IDEDICAO") Integer idedicao) {
        return repository.findById(idedicao);
    }
*/
/*
    @RequestMapping(method = RequestMethod.POST,value = "/updateEdi/{id}")
    //@PostMapping(path = "/ed/salvar/{IDEDICAO}")
    public edicaoModel salvarInstancia(@RequestBody edicaoModel id) {
        Optional<edicaoModel> e = repository.findById();

        return repository.save(id);
    }
*/

    @PostMapping(path = "/ed/{IDEDICAO}/{ano}")
    public ResponseEntity<edicaoModel> getById(@PathVariable("IDEDICAO") Integer idedicao, @PathVariable("ano") String ano) {
          edicaoModel e = repository.findById(idedicao).get();
       // Optional<edicaoModel> book = repository.findById(id);
          repository.findById(idedicao).get().setIdedicao(idedicao);
          repository.findById(idedicao).get().setAno(ano);
          e.setAno(ano);
          repository.save(e);

          System.out.println(idedicao);
        System.out.println(ano);

        //if(isNull(book)) {
        //    throw new RuntimeException("Book not found!");
            return repository.findById(idedicao)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());

    }

}


