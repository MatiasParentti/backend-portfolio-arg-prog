package com.example.demo.service;

import com.example.demo.model.Certification;
import com.example.demo.repository.CertificationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CertificationService {

    @Autowired
    CertificationRepository certificationRepository;

    public List<Certification> list() {
        return certificationRepository.findAll();
    }

    public Optional<Certification> getOne(int id) {
        return certificationRepository.findById(id);
    }

    public void save(Certification education) {
        certificationRepository.save(education);
    }

    public void delete(int id) {
        certificationRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return certificationRepository.existsById(id);
    }

}
