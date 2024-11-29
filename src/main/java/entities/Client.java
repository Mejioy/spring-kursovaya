package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Client  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    @NotBlank(message = "Поле \"Имя\" не может быть пустым")
    @Size(min = 2, max=20, message = "Допустимая длина имени от 2ух до 20ти символов")
    private String name;

    @Column(name = "surname", nullable = false)
    @NotBlank(message = "Поле \"Фамилия\" не может быть пустым")
    @Size(min = 2, max=20, message = "Допустимая длина фамилии от 2ух до 20ти символов")
    private String surName;

    @Column(name = "patronym", nullable = true)
    @Size(min = 2, max=20, message = "Допустимая длина отчества от 2ух до 20ти символов")
    private String patronym;

    @Column(name = "phone", nullable = false)
    @Pattern(regexp = "^\\d\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}$",message = "Телефон должен быть введён в формате: 8(***)***-**-**")
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Automobile> automobiles;

    public Client(long id, String name, String surName, String patronym, String phone) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.patronym = patronym;
        this.phone = phone;
    }
}