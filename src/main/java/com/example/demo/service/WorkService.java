
package com.example.demo.service;


import com.example.demo.model.Work;
import com.example.demo.repository.WorkRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class WorkService {
    
    
     @Autowired
    WorkRepository workRepository;

    public List<Work> list() {
        return workRepository.findAll();
    }

    public Optional<Work> getOne(int id) {
        return workRepository.findById(id);
    }

    public void save(Work work) {
        workRepository.save(work);
    }

    public void delete(int id) {
        workRepository.deleteById(id);
    }

    public boolean existsById(int id) {
        return workRepository.existsById(id);
    }
    
}
