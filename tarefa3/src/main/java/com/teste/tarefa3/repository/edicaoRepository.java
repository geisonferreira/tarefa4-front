package com.teste.tarefa3.repository;

import com.sun.el.stream.Stream;
import com.teste.tarefa3.model.edicaoModel;
import com.teste.tarefa3.model.eventomodel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.stream.DoubleStream;

public interface edicaoRepository extends CrudRepository<edicaoModel, Integer> {


    //@Query("SELECT obj FROM edicaoModel obj WHERE obj.datainicio >= :minSalary AND obj.salary <= :maxSalary")
    //List<eventomodel> findBydatainicio(Double minSalary, Double maxSalary);

//    @Query("SELECT obj FROM edicaoModel obj WHERE obj.cidade = RIO-testeEvento2")
//    List<eventomodel> findBycidade(String cidade);


    @Query("SELECT obj FROM edicaoModel obj WHERE LOWER(obj.cidade) LIKE LOWER(CONCAT('%',:cidade,'%'))")
    List<edicaoModel> searchByCidade(String cidade);



    @Query("SELECT obj FROM edicaoModel obj WHERE obj.datainicio >= :min AND obj.datainicio <= :max")
    List<edicaoModel> searchByData(Double min, Double max);

    //@Query("SELECT obj FROM edicaoModel obj WHERE obj.fkiddevento = :fkidevento")
    //List<edicaoModel> searchByID(Integer fkidevento);

    //("SELECT obje FROM edicaoModel obje WHERE obje.fkiddevento = :fkidevento")
    //SELECT * FROM edicao INNER JOIN evento ON edicao.fk_idevento = evento.idevento;

    //@Query("SELECT obj FROM edicaoModel obj WHERE obj.datainicio >= :min AND obj.cidade = :cidade")
    @Query("SELECT obj FROM edicaoModel obj WHERE obj.datainicio >= :min AND LOWER(obj.cidade) LIKE LOWER(CONCAT('%',:cidade,'%'))")
    List<edicaoModel> searchByDataCidade(Double min, String cidade);

    @Query("SELECT max(idedicao) FROM edicaoModel")
    Integer searchByidedicao();

   // @Query(value = "SELECT max(price) FROM Product")
    //public BigDecimal max();

}



