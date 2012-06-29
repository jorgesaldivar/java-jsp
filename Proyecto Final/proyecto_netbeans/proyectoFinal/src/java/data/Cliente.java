/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author joab
 */
public class Cliente {
    int id;
    String userName;
    String company;
    String address;
    String city;
    String phone;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Cliente(int id, String userName, String company, String address, String city, String phone) {
        this.id = id;
        this.userName = userName;
        this.company = company;
        this.address = address;
        this.city = city;
        this.phone = phone;
    }

   

    public Cliente() {
    }
    
    
    
}
