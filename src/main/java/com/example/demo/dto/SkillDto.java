
package com.example.demo.dto;


public class SkillDto {
    
    private String urlSvg;
     private String nameSkill;

    public SkillDto() {
    }

    public SkillDto(String urlSvg, String nameSkill) {
        this.urlSvg = urlSvg;
        this.nameSkill = nameSkill;
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
