package com.example.demo.dto;

public class WorkDto {

    private String name;
    private String liveCode;
    private String source;
    private String image;
    private String info;
    private String stack;

    public WorkDto() {
    }

    public WorkDto(String name, String liveCode, String source, String image, String info, String stack) {
        this.name = name;
        this.liveCode = liveCode;
        this.source = source;
        this.image = image;
        this.info = info;
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLiveCode() {
        return liveCode;
    }

    public void setLiveCode(String liveCode) {
        this.liveCode = liveCode;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getStack() {
        return stack;
    }

    public void setStack(String stack) {
        this.stack = stack;
    }
    
    
    
    

}
