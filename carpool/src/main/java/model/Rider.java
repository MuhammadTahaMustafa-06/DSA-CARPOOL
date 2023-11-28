package model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Rider {

    @Id
    @OneToOne
    @JoinColumn(name = "UserID")
    private User user;

    @Column(nullable = false)
    private String pickupLocation;

    @Column(nullable = false)
    private String dropoffLocation;

    @Column(nullable = false)
    private String time;

    // Constructors, getters, setters, and other methods...
}
