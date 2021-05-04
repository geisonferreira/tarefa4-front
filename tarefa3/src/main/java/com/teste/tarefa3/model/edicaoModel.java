/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.teste.tarefa3.model;
import java.io.Serializable;
import javax.persistence.*;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

/**
 *
 * @author geisonferreira
 */
@Entity
@Table(name = "edicao")
/*@NamedQueries({
        @NamedQuery(name = "Edicao.findAll", query = "SELECT e FROM Edicao e"),
        @NamedQuery(name = "Edicao.findByIdedicao", query = "SELECT e FROM Edicao e WHERE e.idedicao = :idedicao"),
        @NamedQuery(name = "Edicao.findByDatainicio", query = "SELECT e FROM Edicao e WHERE e.datainicio = :datainicio"),
        @NamedQuery(name = "Edicao.findByDatafim", query = "SELECT e FROM Edicao e WHERE e.datafim = :datafim")})
*/
public class edicaoModel implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    //@NotNull
    @Column(name = "IDEDICAO")
    private Integer idedicao;
    @Lob
    //@Size(max = 16777215)
    @Column(name = "NUMERO")
    private String numero;
    @Lob
    //@Size(max = 16777215)
    @Column(name = "ANO")
    private String ano;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "DATAINICIO")
    private Double datainicio;
    @Column(name = "DATAFIM")
    private Double datafim;
    @Lob
    //@Size(max = 16777215)
    @Column(name = "CIDADE")
    private String cidade;
    @Lob
    //@Size(max = 16777215)
    @Column(name = "PAIS")
    private String pais;
    @JoinColumn(name = "FK_IDEVENTO", referencedColumnName = "IDEVENTO")
    @OneToOne()//@ManyToOne(optional = false)
    private eventomodel fkIdevento;

    public edicaoModel() {
    }

    public edicaoModel(Integer idedicao) {
        this.idedicao = idedicao;
    }

    //public  Integer getIdedicao() {
    //    return idedicao;

    public Integer getIdedicao() {
        return idedicao;
    }

    public void setIdedicao(Integer idedicao) {
        this.idedicao = idedicao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public Double getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Double datainicio) {
        this.datainicio = datainicio;
    }

    public Double getDatafim() {
        return datafim;
    }

    public void setDatafim(Double datafim) {
        this.datafim = datafim;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public eventomodel getFkIdevento() {
        return fkIdevento;
    }

    public void setFkIdevento(eventomodel fkIdevento) {
        this.fkIdevento = fkIdevento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idedicao != null ? idedicao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof edicaoModel)) {
            return false;
        }
        edicaoModel other = (edicaoModel) object;
        if ((this.idedicao == null && other.idedicao != null) || (this.idedicao != null && !this.idedicao.equals(other.idedicao))) {
            return false;
        }
        return true;
    }
//alteração  model.edicaonodel
    @Override
    public String toString() {
        return "model.edicaoModel [ idedicao=" + idedicao + " ]";
    }

}
