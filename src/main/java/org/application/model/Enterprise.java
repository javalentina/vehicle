package org.application.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Enterprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
    @OneToMany(mappedBy = "vehicleId", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;


}
