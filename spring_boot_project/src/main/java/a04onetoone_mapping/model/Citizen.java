package a04onetoone_mapping.model;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

/*

@JsonManagedReference	On the parent side (Citizen) – this will be serialized
@JsonBackReference	On the child side (AadhaarCard) – this will be ignored during serialization
 */

@Entity
@Table(name = "citizen")
public class Citizen {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String gender;

    @OneToOne(mappedBy = "citizen", cascade = CascadeType.ALL)
    @JsonManagedReference
    private AadhaarCard aadhaarCard;

    /*
    | Cascade Type | Description                                                                   |
| ------------ | ----------------------------------------------------------------------------- |
| `PERSIST`    | When the parent is persisted (`save`), the child is also persisted.           |
| `MERGE`      | When the parent is merged (`update`), the child is also merged.               |
| `REMOVE`     | When the parent is deleted, the child is also deleted.                        |
| `REFRESH`    | When the parent is refreshed (reloaded from DB), the child is also refreshed. |
| `DETACH`     | When the parent is detached from the persistence context, the child is too.   |
| `ALL`        | Applies **all** of the above operations.                                      |

     */

    public Citizen() {}

    public Citizen(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public AadhaarCard getAadhaarCard() {
        return aadhaarCard;
    }

    public void setAadhaarCard(AadhaarCard aadhaarCard) {
        this.aadhaarCard = aadhaarCard;
    }
}
