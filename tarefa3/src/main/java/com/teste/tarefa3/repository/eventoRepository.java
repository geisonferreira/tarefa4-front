package com.teste.tarefa3.repository;

import com.teste.tarefa3.model.eventomodel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface eventoRepository extends CrudRepository<eventomodel, Integer> {

    @Query("SELECT max(idevento) FROM eventomodel")
    Integer searchByidevento();


    //@Query("SELECT obj FROM eventomodel obj")
    //List<eventomodel> findeventomodelteste();
}

