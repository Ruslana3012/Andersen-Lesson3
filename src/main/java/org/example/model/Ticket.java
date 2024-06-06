package org.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Getter
@Setter
@ToString
public class Ticket {
    @Size(max = 4, message = "ID can have max 4 digits and/or chars")
    private String ID;
    @Size(max = 10, message = "Concert hall can have max 10 characters long")
    private String concertHall;
    @Pattern(regexp = "\\d{3}", message = "Event code should exactly have 3 digits")
    private String eventCode;
    private long time;
    private boolean isPromo;
    @Pattern(regexp = "[A-C]", message = "Stadium sector must be from 'A' to 'C'")
    private String stadiumSector;
    private double maxAllowedBackpackWeight;
    private BigDecimal price;

    public Ticket() {
    }

    public Ticket(String ID, String concertHall, String eventCode, long time, boolean isPromo, String stadiumSector, double maxAllowedBackpackWeight, BigDecimal price) {
        this.ID = ID;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.price = price;
        validate(this);
    }

    public Ticket(String ID, String concertHall, String eventCode, boolean isPromo, String stadiumSector, double maxAllowedBackpackWeight, BigDecimal price) {
        this.ID = ID;
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = Instant.now().getEpochSecond();
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.price = price;
        validate(this);
    }

    public Ticket(String concertHall, String eventCode, long time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        validate(this);
    }

    public Ticket(String concertHall, String eventCode) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = Instant.now().getEpochSecond();
        validate(this);
    }

    private void validate(Ticket ticket) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        javax.validation.Validator validator = factory.getValidator();

        Set<ConstraintViolation<Ticket>> violations = validator.validate(ticket);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<Ticket> violation : violations) {
                sb.append(violation.getMessage()).append("\n");
            }
            throw new IllegalStateException("Ticket validation failed: \n" + sb.toString());
        }
    }
}
