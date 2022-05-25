package com.example.demo.controller;

import com.example.demo.dto.ExperienceDto;
import com.example.demo.dto.Mensaje;
import com.example.demo.model.Experience;
import com.example.demo.service.ExperienceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/experience")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienceController {

    @Autowired
    ExperienceService experienceService;

    @GetMapping("/lista")
    public ResponseEntity<List<Experience>> list() {
        List<Experience> list = experienceService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Experience> getById(@PathVariable("id") int id) {
        if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Experience experience = experienceService.getOne(id).get();
        return new ResponseEntity(experience, HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ExperienceDto experienceDto) {
        Experience experience = new Experience(experienceDto.getCargo(), experienceDto.getFecha(), experienceDto.getTareas(), experienceDto.getEmpresa());
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("exp agrgada"), HttpStatus.OK);
    }

   @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienceDto experienceDto) {
        Experience experience = experienceService.getOne(id).get();
        experience.setCargo(experienceDto.getCargo());
        experience.setFecha(experienceDto.getFecha());
        experience.setTareas(experienceDto.getTareas());
        experience.setEmpresa(experienceDto.getEmpresa());
        experienceService.save(experience);
        return new ResponseEntity(new Mensaje("exp actualizada"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!experienceService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        experienceService.delete(id);
        return new ResponseEntity(new Mensaje("exp eliminada"), HttpStatus.OK);
    }

}
