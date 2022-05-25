
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String urlSvg;
     private String nameSkill;

    public Skill() {
    }

    public Skill(String urlSvg, String nameSkill) {
        this.urlSvg = urlSvg;
        this.nameSkill = nameSkill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlSvg() {
        return urlSvg;
    }

    public void setUrlSvg(String urlSvg) {
        this.urlSvg = urlSvg;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public void setNameSkill(String nameSkill) {
        this.nameSkill = nameSkill;
    }
    
     
    
}
