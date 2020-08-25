package counselling.com;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Clients extends BaseEntity {


    @Column
    private String ClientNeed;

    public String getClientNeed() {
        return ClientNeed;
    }

    public void setClientNeed(String clientNeed) {
        ClientNeed = clientNeed;
    }
}