package entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Employer {

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

    @Column(name = "city", nullable = false)
    @Size(min = 2, max=35, message = "Допустимая длина названия города от 2ух до 35ти символов")
    private String city;

    @Column(name = "street", nullable = false)
    @Size(min = 2, max=35, message = "Допустимая длина названия улицы от 2ух до 35ти символов")
    private String street;

    @Column(name = "house", nullable = false)
    @Min(value = 1, message = "Номер дома не может быть <= 0")
    private int house;

    @Column(name = "appartment", nullable = true)
    @Min(value = 1, message = "Номер квартиры не может быть <= 0")
    private Integer appartment;

    @OneToMany(mappedBy = "employer_id", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<ProvidedService> providedServices;


    public Employer(long id, String surName, String name, String patronym, String phone,  String city, String street, int house) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.patronym = patronym;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.house = house;
    }

    public Employer(long id,String surName, String name, String patronym, String phone,  String city, String street, int house, int appartment) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.patronym = patronym;
        this.phone = phone;
        this.city = city;
        this.street = street;
        this.house = house;
        this.appartment = appartment;
    }
}
