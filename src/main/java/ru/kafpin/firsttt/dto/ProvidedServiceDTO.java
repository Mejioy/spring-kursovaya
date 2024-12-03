package ru.kafpin.firsttt.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProvidedServiceDTO {
    private String gosnumber;
    private String employerPhone;
    private String serviceName;
    private String provideDate;
}
