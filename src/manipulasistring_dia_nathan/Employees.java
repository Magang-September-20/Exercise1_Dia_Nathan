/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulasistring_dia_nathan;


/**
 *
 * @author yosef
 */
public class Employees {
    private String firstName, lastName,username,password;
    private int id;
    
    public Employees(String firstName, String lastName, String username, String password, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Id Karyawan :"+id+"\nNama Depan : " + firstName +"\nNama Belakang : " 
                + lastName+"\nUsername : " + username+ "\nPass : " + password;
    }

    

    
    
    
}
