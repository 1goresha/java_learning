package ru.igoresha.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igoresha.app.models.User;
import ru.igoresha.app.repositories.UsersRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<User> getUsers(Boolean sort, String by, Boolean desc) {
        if (sort == null || !sort){
            usersRepository.findAll();
        }else{
            switch(by){
                case "age" :
                    if(!desc){
                        return usersRepository.findAllByOrderByAge();
                    }else{
                        return usersRepository.findAllByOrderByAgeDesc();
                    }
                case "id" :
                    if(!desc){
                        return usersRepository.findAllByOrderById();
                    }else{
                        return usersRepository.findAllByOrderByIdDesc();
                    }
            }
        }
        return usersRepository.findAll();
    }

    @Override
    public List<User> findByQuery(String query) {
        return usersRepository.findAllByFirstNameContainsIgnoreCaseOrLastNameContainsIgnoreCase(query, query);
    }
}
