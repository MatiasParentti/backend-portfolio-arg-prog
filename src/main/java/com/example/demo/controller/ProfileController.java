package com.example.demo.controller;

import com.example.demo.dto.ProfileDto;
import com.example.demo.dto.Mensaje;
import com.example.demo.model.Profile;
import com.example.demo.service.ProfileService;
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
@RequestMapping("/profile")
@CrossOrigin(origins = "http://localhost:4200")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/lista")
    public ResponseEntity<List<Profile>> list() {
        List<Profile> list = profileService.list();
        return new ResponseEntity(list, HttpStatus.OK);

    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Profile> getById(@PathVariable("id") int id) {
        if (!profileService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        Profile profile = profileService.getOne(id).get();
        return new ResponseEntity(profile, HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ProfileDto profileDto) {
        Profile profile = new Profile(profileDto.getName(), profileDto.getLastname(), profileDto.getAbout(), profileDto.getImageUrl(), profileDto.getEmail(), profileDto.getGithub(), profileDto.getLinkedin());
        profileService.save(profile);
        return new ResponseEntity(new Mensaje("perfil agregado"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ProfileDto profileDto) {
        Profile profile = profileService.getOne(id).get();
        profile.setName(profileDto.getName());
        profile.setLastname(profileDto.getLastname());
        profile.setAbout(profileDto.getAbout());
        profile.setImageUrl(profileDto.getImageUrl());
        profile.setEmail(profileDto.getEmail());
        profile.setGithub(profileDto.getGithub());
        profile.setLinkedin(profileDto.getLinkedin());
        profileService.save(profile);
        return new ResponseEntity(new Mensaje("perfil actualizado"), HttpStatus.OK);
    }
@PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!profileService.existsById(id)) {
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        }
        profileService.delete(id);
        return new ResponseEntity(new Mensaje("perfil eliminao"), HttpStatus.OK);
    }

}
