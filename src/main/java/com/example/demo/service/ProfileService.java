package com.example.demo.service;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public List<Profile> list() {
        return profileRepository.findAll();
    }

    public Optional<Profile> getOne(int id) {
        return profileRepository.findById(id);
    }

    public void save(Profile profile) {
        profileRepository.save(profile);
    }

    public void delete(int id) {
        profileRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return profileRepository.existsById(id);
    }

}
