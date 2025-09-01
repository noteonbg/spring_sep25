package a02basicpoc.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter @Setter
public class InvestmentDto {
    private String investmentType;
    private String assetName;
    private BigDecimal amountInvested;
    private BigDecimal currentValue;
    private LocalDate dateOfInvestment;
    private LocalDate maturityDate;
}

