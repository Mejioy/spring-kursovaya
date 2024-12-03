package ru.kafpin.firsttt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.kafpin.firsttt.entities.*;
import ru.kafpin.firsttt.services.*;

import java.time.LocalDate;

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

    @GetMapping("/services")
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
    @PostMapping("/automobile/add")
    public Automobile newAutomobile(@RequestBody Automobile automobile){
        return automobileService.addEditAutomobile(automobile);
    }

    @PostMapping("/client/add")
    public Client newClient(@RequestBody Client client){
        return clientService.addEditClient(client);
    }

    @PostMapping("/employer/add")
    public Employer newEmployer(@RequestBody Employer employer){
        return employerService.addEditEmployer(employer);
    }

    @PostMapping("/service/add")
    public Service newService(@RequestBody Service service){
        return serviceService.addEditService(service);
    }

    @PostMapping("/providedservice/add")
    public ProvidedService newProvidedService(@RequestBody ProvidedService providedService){
        return providedServiceService.addEditProvidedService(providedService);
    }

    ///Standard puts
    @PutMapping("/automobile/{id}")
    public Automobile updateAutomobile(@RequestBody Automobile automobile,
                           @PathVariable("id") Long id){
        return automobileService.addEditAutomobile(automobile);
    }

    @PutMapping("/client/{id}")
    public Client updateClient(@RequestBody Client client,
                                       @PathVariable("id") Long id){
        return clientService.addEditClient(client);
    }

    @PutMapping("/employer/{id}")
    public Employer updateEmployer(@RequestBody Employer employer,
                                       @PathVariable("id") Long id){
        return employerService.addEditEmployer(employer);
    }

    @PutMapping("/service/{id}")
    public Service updateService(@RequestBody Service service,
                                       @PathVariable("id") Long id){
        return serviceService.addEditService(service);
    }

    @PutMapping("/providedservice/{id}")
    public ProvidedService updateProvidedService(@RequestBody ProvidedService providedService,
                                       @PathVariable("id") Long id){
        return providedServiceService.addEditProvidedService(providedService);
    }
    ///Standard deletes
    @DeleteMapping("/automobile/{id}")
    public void deleteAutomobile(@PathVariable("id") Long id){
        automobileService.deleteAutomobileById(id);
    }

    @DeleteMapping("/client/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/employer/{id}")
    public void deleteEmployer(@PathVariable("id") Long id){
        employerService.deleteEmployerById(id);
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable("id") Long id){
        serviceService.deleteServiceById(id);
    }

    @DeleteMapping("/providedservice/{id}")
    public void deleteProvidedService(@PathVariable("id") Long id){
        providedServiceService.deleteProvidedServiceById(id);
    }
}
