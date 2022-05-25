package com.example.demo.controller;

import com.example.demo.dto.CertificationDto;
import com.example.demo.dto.Mensaje;
import com.example.demo.model.Certification;
import com.example.demo.service.CertificationService;
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
@RequestMapping("/certification")
@CrossOrigin(origins = "http://localhost:4200")
public class CertificationController {

    @Autowired
    CertificationService certificationService;

    @GetMapping("/lista")
    public ResponseEntity<List<Certification>> list() {
        List<Certification> list = certificationService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Certification> getById(@PathVariable("id") int id) {
        if (!certificationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Certification certification = certificationService.getOne(id).get();
        return new ResponseEntity(certification, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CertificationDto certificationDto) {
        Certification certification = new Certification(certificationDto.getPrograma(), certificationDto.getInstituto(), certificationDto.getEnlace());
        certificationService.save(certification);
        return new ResponseEntity(new Mensaje("certificacion agregada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody CertificationDto certificationDto) {
        Certification certification = certificationService.getOne(id).get();
        certification.setPrograma(certificationDto.getPrograma());
        certification.setInstituto(certificationDto.getInstituto());
        certification.setEnlace(certificationDto.getEnlace());

        certificationService.save(certification);
        return new ResponseEntity(new Mensaje("certificacion actualizada"), HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!certificationService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        certificationService.delete(id);
        return new ResponseEntity(new Mensaje("certificacion eliminada"), HttpStatus.OK);
    }

}
