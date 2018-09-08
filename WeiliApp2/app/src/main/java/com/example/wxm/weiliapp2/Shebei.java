package com.example.wxm.weiliapp2;

public class Shebei {
    private String name,id,time;
    private int logo;
    private float wendu;
    private float shidu;
    private int normal_wendu;
    private boolean isNormal,isInline;
    private int normal_shidu;
    private double positionX,positionY;
    public Shebei(){}

    public Shebei(String name, String id, float wendu,float shidu, String time, int logo,boolean isNormal,boolean isInline) {
        this.name = name;
        this.id = id;
        this.wendu = wendu;
        this.shidu=shidu;
        this.time = time;
        this.logo = logo;
        this.isNormal=isNormal;
        this.isInline=isInline;
    }
    public Shebei(String name, String id, float wendu,float shidu, String time, int logo,boolean isNormal,boolean isInline,double positionX,double positionY) {
        this.name = name;
        this.id = id;
        this.wendu = wendu;
        this.shidu=shidu;
        this.time = time;
        this.logo = logo;
        this.isNormal=isNormal;
        this.isInline=isInline;
        this.positionX=positionX;
        this.positionY=positionY;
    }



    public double getPositionX() {
        return positionX;
    }

    public void setPositionX(double positionX) {
        this.positionX = positionX;
    }

    public double getPositionY() {
        return positionY;
    }

    public void setPositionY(double positionY) {
        this.positionY = positionY;
    }

    public boolean isNormal() {
        return isNormal;
    }

    public void setNormal(boolean normal) {
        isNormal = normal;
    }

    public boolean isInline() {
        return isInline;
    }

    public void setInline(boolean inline) {
        isInline = inline;
    }


    public int getNormal_wendu() {
        return normal_wendu;
    }

    public void setNormal_wendu(int normal_wendu) {
        this.normal_wendu = normal_wendu;
    }

    public int getNormal_shidu() {
        return normal_shidu;
    }

    public void setNormal_shidu(int normal_shidu) {
        this.normal_shidu = normal_shidu;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getWendu() {
        return wendu;
    }

    public float getShidu() {
        return shidu;
    }

    public void setShidu(float shidu) {
        this.shidu = shidu;
    }

    public void setWendu(float wendu) {
        this.wendu = wendu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
