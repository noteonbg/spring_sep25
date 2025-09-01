package a04onetoone_mapping.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/*

@JsonManagedReference	On the parent side (Citizen) – this will be serialized
@JsonBackReference	On the child side (AadhaarCard) – this will be ignored during serialization

 */

@Entity
@Table(name = "aadhaar_card")
public class AadhaarCard {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String aadhaarNumber;

    @OneToOne
    @JoinColumn(name = "citizen_id", referencedColumnName = "id")
    @JsonBackReference
    private Citizen citizen;

    public AadhaarCard() {}

    public AadhaarCard(String aadhaarNumber, Citizen citizen) {
        this.aadhaarNumber = aadhaarNumber;
        this.citizen = citizen;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAadhaarNumber() {
        return aadhaarNumber;
    }

    public void setAadhaarNumber(String aadhaarNumber) {
        this.aadhaarNumber = aadhaarNumber;
    }

    public Citizen getCitizen() {
        return citizen;
    }

    public void setCitizen(Citizen citizen) {
        this.citizen = citizen;
    }
}
