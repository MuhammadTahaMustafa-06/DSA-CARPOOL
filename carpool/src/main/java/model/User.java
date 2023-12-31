package model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;


@Data
@Entity
public class User {

    @Id
    private String userId;

    private String password;

    private String name;

    private String phoneNumber;



}