package counselling.com;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "counsellors")
public class Counsellors extends BaseEntity {

  @OneToMany(mappedBy = "clients")
  private List<Clients> clients = new ArrayList<Clients>();


   @Column
   private String qualifications;

   @Column
   private String AreaOfExpertise;


   public String getQualifications() {
       return qualifications;
   }

   public void setQualifications(String qualifications) {
       this.qualifications = qualifications;
   }

   public String getAreaOfExpertise() {
       return AreaOfExpertise;
   }

   public void setAreaOfExpertise(String areaOfExpertise) {
       AreaOfExpertise = areaOfExpertise;
   }


}
