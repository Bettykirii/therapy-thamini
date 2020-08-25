package counselling.com;

import javax.persistence.*;

@Entity
@Table(name = "counsellors")
public class Counsellors extends BaseEntity {

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
