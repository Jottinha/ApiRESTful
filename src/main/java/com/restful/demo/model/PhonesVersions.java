package com.restful.demo.model;

import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PhonesVersions extends RepresentationModel<PhonesVersions> implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idPhone")
    private long id;
    private String namePhone;
    private double valor;

    public long getIdPhone() {
        return id;
    }

    public void setIdPhone(long idPhone) {
        this.id = idPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
