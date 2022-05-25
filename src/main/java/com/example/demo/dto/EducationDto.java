
package com.example.demo.dto;


public class EducationDto {
    
    private String instituto;
    private String fecha;
    private String programa;
    private String estado;

    public EducationDto() {
    }

    public EducationDto(String instituto, String fecha, String programa, String estado) {
        this.instituto = instituto;
        this.fecha = fecha;
        this.programa = programa;
        this.estado = estado;
    }

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrograma() {
        return programa;
    }

    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
