
package com.example.demo.dto;


public class ProfileDto {
    
    private String name;
    private String lastname;
    private String about;
    private String imageUrl;
    private String email;
    private String github;
    private String linkedin;

    public ProfileDto() {
    }

    public ProfileDto(String name, String lastname, String about, String imageUrl, String email, String github, String linkedin) {
        this.name = name;
        this.lastname = lastname;
        this.about = about;
        this.imageUrl = imageUrl;
        this.email = email;
        this.github = github;
        this.linkedin = linkedin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getLinkedin() {
        return linkedin;
    }

    public void setLinkedin(String linkedin) {
        this.linkedin = linkedin;
    }
    
}
