package ru.kafpin.firsttt.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "name")
        },
        name = "services"
)
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

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

    @OneToMany(mappedBy = "service", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProvidedService> providedServices;

    public Service(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Service(long id, String name, int price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

}
