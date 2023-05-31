package com.tunisair.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.*;

@Embeddable
public class MenuId implements Serializable {

    @Column(name = "numeroVol")
    private Long numeroVol;

    @Column(name = "idRestauration")
    private Long idRestauration;

    public Long getNumeroVol() {
        return this.numeroVol;
    }

    public void setNumeroVol(Long numeroVol) {
        this.numeroVol = numeroVol;
    }

    public Long getIdRestauration() {
        return this.idRestauration;
    }

    public void setIdRestauration(Long idRestauration) {
        this.idRestauration = idRestauration;
    }

}
