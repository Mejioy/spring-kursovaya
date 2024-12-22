package ru.kafpin.firsttt.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kafpin.firsttt.UserDTO;
import ru.kafpin.firsttt.WebSecurityConfig;
import ru.kafpin.firsttt.entities.Client;
import ru.kafpin.firsttt.entities.User;
import ru.kafpin.firsttt.repositories.UserRepository;

import java.util.Collections;

import static ru.kafpin.firsttt.entities.User.Role.ROLE_USER;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(user ->
                        new org.springframework.security.core.userdetails.User(
                                user.getUsername(),
                                user.getPassword(),
                                Collections.singleton(user.getRole())
                        ))
                .orElseThrow(()-> new UsernameNotFoundException("Невозможно найти пользователя " + username));
    }



    public String createUser(UserDTO user){
        if(userRepository.findByUsername(user.getPhone()).isEmpty()){
            User newUser = new User();
            newUser.setUsername(user.getPhone());
            newUser.setPassword(user.getPassword());
            newUser.setRole(ROLE_USER);
            Client newClient = new Client();
            newClient.setSurName(user.getSurName());
            newClient.setName(user.getName());
            newClient.setPatronym(user.getPatronym());
            newClient.setPhone(user.getPhone());
            clientService.addEditClient(newClient);
            userRepository.save(newUser);
            return "success registry";
        }
        else
            return "user with this login already exists";
    }
}