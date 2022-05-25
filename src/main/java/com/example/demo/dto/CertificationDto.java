
package com.example.demo.dto;


public class CertificationDto {
    
    private String programa;
     private String instituto;
      private String enlace;

    public CertificationDto() {
    }

    public CertificationDto(String programa, String instituto, String enlace) {
        this.programa = programa;
        this.instituto = instituto;
        this.enlace = enlace;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    
      
      
}
