package ru.kafpin.firsttt.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints =
        {
                @UniqueConstraint(columnNames = "id"),
                @UniqueConstraint(columnNames = "gosnumber")
        },
        name = "automobiles"
)
public class Automobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "mark", nullable = false)
    @NotBlank(message = "Поле \"Марка\" не может быть пустым")
    @Size(min = 2, max=20, message = "Допустимая длина марки от 2ух до 20ти символов")
    private String mark;

    @Column(name = "model", nullable = false)
    @NotBlank(message = "Поле \"Модель\" не может быть пустым")
    @Size(min = 2, max=20, message = "Допустимая длина модели от 2ух до 20ти символов")
    private String model;

    @Column(name = "gosnumber", nullable = false)
    @Pattern(regexp = "^[ABEKMHOPCTYX]\\d{3}(?<!000)[ABEKMHOPCTYX]{2}\\d{2,3}rus$")
    private String gosnumber;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToMany(mappedBy = "automobile", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProvidedService> providedServices;
}