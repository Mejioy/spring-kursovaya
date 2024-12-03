package ru.kafpin.firsttt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kafpin.firsttt.entities.*;
import ru.kafpin.firsttt.services.*;

@RequestMapping("/api")
@RestController
public class ApiController {

    ///Services init
    private AutomobileService automobileService;
    @Autowired
    public void setAutomobileService(AutomobileService automobileService){
        this.automobileService = automobileService;
    }

    private ClientService clientService;
    @Autowired
    public void setClientService(ClientService clientService){
        this.clientService = clientService;
    }

    private EmployerService employerService;
    @Autowired
    public void setEmployerService(EmployerService employerService){
        this.employerService = employerService;
    }

    private ServiceService serviceService;
    @Autowired
    public void setServiceService(ServiceService serviceService){
        this.serviceService = serviceService;
    }

    private ProvidedServiceService providedServiceService;
    @Autowired
    public void setProvidedServiceService(ProvidedServiceService providedServiceService){
        this.providedServiceService = providedServiceService;
    }


    ///Standard getAll
    @GetMapping("/automobiles")
    public Iterable<Automobile> listOfAutomobiles(){
        return automobileService.getAllAutomobiles();
    }

    @GetMapping("/clients")
    public Iterable<Client> listOfClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/employers")
    public Iterable<Employer> listOfEmployers(){
        return employerService.getAllEmployers();
    }

    @GetMapping("/ru/kafpin/firsttt/services")
    public Iterable<Service> listOfServices(){
        return serviceService.getAllServices();
    }

    @GetMapping("/providedservices")
    public Iterable<ProvidedService> listOfProvidedServices(){
        return providedServiceService.getAllProvidedServices();
    }

    ///Standard getById
    @GetMapping("/automobile/{id}")
    public Automobile getAutomobile(@PathVariable("id") Long id){
        return automobileService.getAutomobileById(id);
    }

    @GetMapping("/client/{id}")
    public Client getClient(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @GetMapping("/employer/{id}")
    public Employer getEmployer(@PathVariable("id") Long id){
        return employerService.getEmployerById(id);
    }

    @GetMapping("/service/{id}")
    public Service getService(@PathVariable("id") Long id){
        return serviceService.getServiceById(id);
    }

    @GetMapping("/providedservice/{id}")
    public ProvidedService getProvidedService(@PathVariable("id") Long id) {
        return providedServiceService.getProvidedServiceById(id);
    }

    ///Standard posts

    ///Standard puts

    ///Standard deletes

}
