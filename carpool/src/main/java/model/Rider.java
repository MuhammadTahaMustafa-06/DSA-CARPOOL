package model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
public class Rider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long riderID;

    @OneToOne
    @JoinColumn(name = "UserID") // Adjust the name to match the field in the User entity
    private User user;

    @Column(nullable = false)
    private String pickupLocation;

    @Column(nullable = false)
    private String dropoffLocation;

    @Column(nullable = false)
    private java.sql.Timestamp time;

    public Long getRiderID() {
        return riderID;
    }

    public void setRiderID(Long riderID) {
        this.riderID = riderID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}
