package models;

import org.hibernate.Session;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name = "appointments")
public class Appointments {

//    @ManyToOne
//    private Clients clients;

    @Embedded
     private Clients clients;

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }
}
