package a05onetomany.model;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Medicine {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "pharmacy_id") // foreign key column in medicine table
    private Pharmacy pharmacy;
    /*
    Create a foreign key column in the medicine table called
     pharmacy_id
    that links each medicine to a pharmacy.

     */

    public Medicine() {}

    public Medicine(String name, double price, Pharmacy pharmacy) {
        this.name = name;
        this.price = price;
        this.pharmacy = pharmacy;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}

