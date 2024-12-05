package ru.kafpin.firsttt.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Table(uniqueConstraints= @UniqueConstraint(columnNames={"id", "dateofprovide"}) ,
//        name = "providedservices")
@Table(name = "providedservices")
public class ProvidedService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @ManyToOne
    @JoinColumn(name = "employer_id")
    private Employer employer;

    @ManyToOne
    @JoinColumn(name = "automobile_id")
    private Automobile automobile;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Column(name = "dateofprovide", nullable = false)
    private LocalDate dateOfProvide;
}