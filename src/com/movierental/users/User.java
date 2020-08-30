package com.movierental.users;

public class User {
    private String id;
    private String name;
    private String surname;
    private String phone;
    private String address;
    private String city;

    public void setId(String idIn) {
        this.id = idIn;
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public void setSurname(String surnameIn) {
        this.surname = surnameIn;
    }

    public void setPhone(String phoneIn) {
        this.phone = phoneIn;
    }

    public void setAddress(String addressIn) {
        this.address = addressIn;
    }

    public void setCity(String cityIn) {
        this.city = cityIn;
    }

    public String getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getSurname(){
        return this.surname;
    }

    public String getPhone(){
        return this.phone;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCity(){
        return this.city;
    }
}
