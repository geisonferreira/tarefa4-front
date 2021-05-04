package com.teste.tarefa3.repository;

import com.teste.tarefa3.model.usuarioModel;
import org.springframework.data.repository.CrudRepository;

public interface usuarioRepository extends CrudRepository <usuarioModel, Integer> {
}
