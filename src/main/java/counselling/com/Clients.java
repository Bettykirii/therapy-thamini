package counselling.com;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Clients extends BaseEntity {



    @Column(qualifications = "counsellor_qualifications", columnDefinition = "LONGTEXT")
    private String qualifications;

    @Column(AreaOfExpertise = "counsellor_Expertise", columnDefinition = "LONGTEXT")
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
