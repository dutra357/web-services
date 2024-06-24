package com.demo.web_services.Services;

import com.demo.web_services.Entities.Users;
import com.demo.web_services.Exception.ResourceNotFoundException;
import com.demo.web_services.Repositories.UsersRepo;
import com.demo.web_services.Services.Exceptions.DatabaseException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UsersRepo repository;
    public UserService(UsersRepo repository) {
        this.repository = repository;
    }


    public List<Users> findAll() {
        return repository.findAll();
    }

    public Users findById(Long id) {
        Optional<Users> user = repository.findById(id);
        return user.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Users insert(Users user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException msg) {
            throw new DatabaseException(msg.getMessage());
        }
    }

    public Users update(Long id, Users user) {
        //'getReferenceById()' not get the user in db, only prepare a mock obj.
        Users entity = repository.getReferenceById(id);
        updateData(entity, user);
        return repository.save(entity);
    }

    private void updateData(Users entity, Users user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
