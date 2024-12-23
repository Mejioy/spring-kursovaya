package ru.kafpin.firsttt.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames={"id","name", "status"})
        },
        name = "services"
)
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Поле \"Название\" не может быть пустым")
    @Size(min = 2, max=70, message = "Допустимая длина названия услуги от 2ух до 70ти символов")
    private String name;

    @Column(name = "price", nullable = false)
    @Min(value = 0, message = "Стоимость не может быть < 0")
    private int price;

    @Column(name = "description", nullable = true)
    @Size(min = 2, max=200, message = "Допустимая длина названия услуги от 2ух до 200от символов")
    private String description;

    @Column(name = "status",nullable = false)
    private boolean status;

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProvidedService> providedServices;
}