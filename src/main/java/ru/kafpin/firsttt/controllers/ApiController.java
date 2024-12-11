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
    @Autowired
    private AutomobileService automobileService;

    @Autowired
    private ClientService clientService;

    @Autowired
    private EmployerService employerService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private ProvidedServiceService providedServiceService;

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

    @GetMapping("/automobiles/{id}")
    public Automobile getAutomobile(@PathVariable("id") Long id){
        return automobileService.getAutomobileById(id);
    }

    @GetMapping("/clients/{id}")
    public Client getClient(@PathVariable("id") Long id){
        return clientService.getClientById(id);
    }

    @GetMapping("/employers/{id}")
    public Employer getEmployer(@PathVariable("id") Long id){
        return employerService.getEmployerById(id);
    }

    @GetMapping("/services/{id}")
    public Service getService(@PathVariable("id") Long id){
        return serviceService.getServiceById(id);
    }

    @GetMapping("/providedservices/{id}")
    public ProvidedService getProvidedService(@PathVariable("id") Long id) {
        return providedServiceService.getProvidedServiceById(id);
    }

    ///Standard posts
    @PostMapping("/automobiles")
    public Automobile newAutomobile(@RequestBody Automobile automobile){
        return automobileService.addEditAutomobile(automobile);
    }

    @PostMapping("/clients")
    public Client newClient(@RequestBody Client client){
        return clientService.addEditClient(client);
    }

    @PostMapping("/employers")
    public Employer newEmployer(@RequestBody Employer employer){
        return employerService.addEditEmployer(employer);
    }

    @PostMapping("/services")
    public Service newService(@RequestBody Service service){
        return serviceService.addEditService(service);
    }

    @PostMapping("/providedservices")
    public ProvidedService newProvidedService(@RequestBody ProvidedService providedService){
        return providedServiceService.addEditProvidedService(providedService);
    }

    ///Standard puts
    @PutMapping("/automobiles/{id}")
    public Automobile updateAutomobile(@RequestBody Automobile automobile,
                           @PathVariable("id") Long id){
        return automobileService.addEditAutomobile(automobile);
    }

    @PutMapping("/clients/{id}")
    public Client updateClient(@RequestBody Client client,
                                       @PathVariable("id") Long id){
        return clientService.addEditClient(client);
    }

    @PutMapping("/employers/{id}")
    public Employer updateEmployer(@RequestBody Employer employer,
                                       @PathVariable("id") Long id){
        return employerService.addEditEmployer(employer);
    }

    @PutMapping("/services/{id}")
    public Service updateService(@RequestBody Service service,
                                       @PathVariable("id") Long id){
        return serviceService.addEditService(service);
    }

    @PutMapping("/providedservices/{id}")
    public ProvidedService updateProvidedService(@RequestBody ProvidedService providedService,
                                       @PathVariable("id") Long id){
        return providedServiceService.addEditProvidedService(providedService);
    }

    ///Standard deletes
    @DeleteMapping("/automobiles/{id}")
    public void deleteAutomobile(@PathVariable("id") Long id){
        automobileService.deleteAutomobileById(id);
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
    }

    @DeleteMapping("/employers/{id}")
    public void deleteEmployer(@PathVariable("id") Long id){
        employerService.deleteEmployerById(id);
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable("id") Long id){
        serviceService.deleteServiceById(id);
    }

    @DeleteMapping("/providedservices/{id}")
    public void deleteProvidedService(@PathVariable("id") Long id){
        providedServiceService.deleteProvidedServiceById(id);
    }

    ///Unstandart responses
    @GetMapping("/automobiles/owner/{id}")
    public Iterable<Automobile> listOfAutomobiles(@PathVariable("id") Long id){
        return automobileService.getAllAutomobilesByClientId(id);
    }

    @GetMapping("/clients/phone/{phone}")
    public Client getClientByPhone(@PathVariable("phone") String phone){
        return clientService.getClientByPhone(phone);
    }

    @GetMapping("/automobiles/gosnumber/{gosnumber}")
    public Automobile getAutomobileByGosnumber(@PathVariable("gosnumber") String gosnumber){
        return automobileService.getAutomobileByGosnumber(gosnumber);
    }

    @GetMapping("/employers/phone/{phone}")
    public Employer getEmployerByPhone(@PathVariable("phone") String phone){
        return employerService.getEmployerByPhone(phone);
    }

    @GetMapping("/services/name/{name}")
    public Service getServiceByName(@PathVariable("name") String name){
        return serviceService.getServiceByName(name);
    }

    @GetMapping("/providededservices/between/from={from}to={to}")
    public Iterable<ProvidedService> listOfProvidedServices(@PathVariable("from") LocalDate from,@PathVariable("to") LocalDate to ){
        return providedServiceService.getAllProvidedServicesFromTo(from,to);
    }

    @GetMapping("/providededservices/automobile/{id}")
    public Iterable<ProvidedService> listOfProvidedServices(@PathVariable("id") Long id){
        return providedServiceService.getAllProvidedServicesByAutomobileId(id);
    }
}
