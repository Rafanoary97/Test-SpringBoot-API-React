package com.dani.monkeyd.app.appingen.services;

import com.dani.monkeyd.app.appingen.models.Users;
import com.dani.monkeyd.app.appingen.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    @Autowired
    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Users> getAllUser(){
        return usersRepository.findAll();
    }

    public Users getUser(String email){
        Users user1 = new Users();
        List<Users> users=usersRepository.findAll();
        for (Users u:users)
            if (u.getEmail().equals(email)){
                user1= usersRepository.findById(u.getId()).get();
            }
        return user1;
    }

    public String authUser(String email){
        String mdp = null;
        Users user1 = new Users();
        List<Users> users=usersRepository.findAll();
        for (Users u:users)
            if (u.getEmail().equals(email)){
             user1= usersRepository.findById(u.getId()).get();
            mdp= user1.getPassword();
            }
        return mdp;
    }
//    public Users findUsersPsd(String password){
//     return usersRepository.findUsersPsw(password).orElseThrow(()->new UserNotFoundException("User by Password " +password+" not found."));
//    }

    public Users addUsers(Users users){
        return usersRepository.save(users);
    }

    public Users updateUsers(Users users){
      return usersRepository.save(users);
    }

    public void deleteUsersByEmail(String email){
        List<Users> users=usersRepository.findAll();
        for (Users u:users)
            if (u.getEmail().equals(email)){
                usersRepository.deleteById(u.getId());
            }
    }


}
