package com.example.demo.controller;


import com.example.demo.dto.Mensaje;
import com.example.demo.dto.WorkDto;
import com.example.demo.model.Work;
import com.example.demo.service.WorkService;
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
@RequestMapping("/work")
@CrossOrigin(origins = "http://localhost:4200")
public class WorkController {

    @Autowired
    WorkService workService;

    @GetMapping("/lista")
    public ResponseEntity<List<Work>> list() {
        List<Work> list = workService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Work> getById(@PathVariable("id") int id) {
        if (!workService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Work work = workService.getOne(id).get();
        return new ResponseEntity(work, HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WorkDto workDto) {
        Work work = new Work(workDto.getName(), workDto.getLiveCode(), workDto.getSource(), workDto.getImage(), workDto.getInfo(), workDto.getStack());
        workService.save(work);
        return new ResponseEntity(new Mensaje("work agregada"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody WorkDto workDto) {
        Work work = workService.getOne(id).get();
        work.setName(workDto.getName());
        work.setLiveCode(workDto.getLiveCode());
        work.setSource(workDto.getSource());
        work.setImage(workDto.getImage());
        work.setInfo(workDto.getInfo());
        work.setStack(workDto.getStack());
        workService.save(work);
        return new ResponseEntity(new Mensaje("work actualizada"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!workService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        workService.delete(id);
        return new ResponseEntity(new Mensaje("work eliminada"), HttpStatus.OK);
    }

}
