package com.example.usuario.examenii_lpiii.bean;

/**
 * Created by Usuario on 25/04/2017.
 */

public class Person {

    private int PersonId;
    private String Name;
    private String LastNames;
    private String UserName;
    private String Password;
    private String Status;


    private Integer photo;


    public Person(int personId, String name, String lastNames, String userName, String password, String status, Integer photo) {
        this.PersonId = personId;
        this.Name = name;
        this.LastNames = lastNames;
        this.UserName = userName;
        this.Password = password;
        this.Status = status;
        this.photo = photo;


    }

    public Person() {

    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastNames() {
        return LastNames;
    }

    public void setLastNames(String lastNames) {
        LastNames = lastNames;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return Name + " " + LastNames +" " + UserName+" - "+Password+ " - "+ Status ;
    }


}
