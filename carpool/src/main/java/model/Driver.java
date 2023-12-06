package model;

import jakarta.persistence.*;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverID;

    @OneToOne
    @JoinColumn(name = "UserID") // Adjust the name to match the field in the User entity
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

    public Long getDriverID() {
        return driverID;
    }

    public void setDriverID(Long driverID) {
        this.driverID = driverID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStartpoint() {
        return startpoint;
    }

    public void setStartpoint(String startpoint) {
        this.startpoint = startpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public String getCarNumberPlate() {
        return carNumberPlate;
    }

    public void setCarNumberPlate(String carNumberPlate) {
        this.carNumberPlate = carNumberPlate;
    }
}
