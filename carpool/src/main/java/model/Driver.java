package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Driver {

    @Id
    @OneToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(nullable = false)
    private String startpoint;

    @Column(nullable = false)
    private String endpoint;

    @Column(nullable = false)
    private String carModel;

    @Column(nullable = false)
    private String carColor;

    @Column(nullable = false)
    private String carNumberPlate;

    // Constructors, getters, setters, and other methods...
}
