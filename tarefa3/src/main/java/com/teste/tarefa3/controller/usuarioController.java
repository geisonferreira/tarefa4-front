package com.teste.tarefa3.controller;
import com.teste.tarefa3.model.usuarioModel;
import com.teste.tarefa3.repository.usuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class usuarioController {

    @Autowired
    usuarioRepository repository;

    @GetMapping(path="/api/usuario/{codigo}")
    public ResponseEntity consultar(@PathVariable("codigo") Integer codigo){
    return repository.findById(codigo)
            .map(record->ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
}

   /* @PostMapping(path="/api/usario/salvar")*/
   /*@RequestMapping(
           value = "/api/usario/salvar",
           produces = "application/json",
           method = {RequestMethod.GET, RequestMethod.POST})*/

    @PostMapping(path = "/api/usuario/salvar")
    public usuarioModel salvar(@RequestBody usuarioModel usuario) {
        return repository.save(usuario);   }
    }


