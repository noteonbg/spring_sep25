package a05onetomany.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Pharmacy {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;

    @JsonManagedReference
    @OneToMany(mappedBy = "pharmacy", cascade = CascadeType.ALL)
    private List<Medicine> medicines;
/*
    One Pharmacy object is associated with many Medicine objects.
    pharmacy  is name of the object in Medicine
    The relationship is owned by the pharmacy field in the Medicine entity.
So, the foreign key will be in the medicine table, not in pharmacy.

Cascade.All meaning
Saving a Pharmacy will also save its Medicines.
Deleting a Pharmacy will delete its Medicines.


*/

    public Pharmacy() {}

    public Pharmacy(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines) {
        this.medicines = medicines;
    }
}
