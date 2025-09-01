package a02basicpoc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Getter @Setter @NoArgsConstructor
public class Investment {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String investmentType;
    private String assetName;
    private BigDecimal amountInvested;
    private BigDecimal currentValue;
    private LocalDate dateOfInvestment;
    private LocalDate maturityDate;

    /*

    @JsonManagedReference	Parent (User)	Serializes normally (shown in JSON)
@JsonBackReference	Child (Investment)	Skips serialization to avoid recursion loop

     */


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}

