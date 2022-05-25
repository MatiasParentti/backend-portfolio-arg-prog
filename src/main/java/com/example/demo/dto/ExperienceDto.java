package com.example.demo.dto;

public class ExperienceDto {

    private String cargo;
    private String fecha;
    private String tareas;
    private String empresa;

    public ExperienceDto() {
    }

    public ExperienceDto(String cargo, String fecha, String tareas, String empresa) {
        this.cargo = cargo;
        this.fecha = fecha;
        this.tareas = tareas;
        this.empresa = empresa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTareas() {
        return tareas;
    }

    public void setTareas(String tareas) {
        this.tareas = tareas;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

}
