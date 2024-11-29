package services;

import entities.Client;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    public void setClientRepository(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return (List<Client>) clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            throw new EntityNotFoundException("Клиент не найден");
        }
        return client.get();
    }

    public void deleteClientById(Long id) {
        if (clientRepository.existsById(id))
            clientRepository.deleteById(id);
    }

    public Client addEditClient(Client client) {
        return clientRepository.save(client);
    }
}
