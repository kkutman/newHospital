package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

/**
 * name : kutman
 **/
@Entity
@Table(name = "patients")
@NoArgsConstructor
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String gender;
    private String email;
    @ManyToOne
    private Hospital hospital;
    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;
    @Transient
    private Long hospitalId;
}
