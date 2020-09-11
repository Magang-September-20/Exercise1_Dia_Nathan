/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulasistring_dia_nathan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author sweje
 */
public class Main {
    ArrayList<Employees> tampung;

    public Main() {
        tampung = new ArrayList<>();
    }

    public void isiData(String namaLengkap, String password) {
//        manipulasi string disini
        String lastName="",firstName="", username="";
        String[] split = namaLengkap.split(" ");
        if (split.length <=1){
            lastName = split[0];
            firstName= split[0];
        }
        else{
            lastName=split[split.length-1];
            String[] removedElement = Arrays.copyOf(split, split.length-1);
            firstName = String.join(" ", removedElement);
        }
        username=split[0];
        
        tampung.add(new Employees(firstName, lastName, username, password, 0));
        System.out.println("--Data ditambah--");

    }

    public void showData() {
        if (tampung.isEmpty()) {
            System.out.println("--------------");
            System.out.println("Data tidak ada");
            System.out.println("--------------");
        } else {
            System.out.println("--------------");
            System.out.println("Data employees");
            System.out.println("--------------");

            for (Employees emp : tampung) {
                System.out.println(emp);
               
//                String[] kata = emp.getNamalengkap().split("\\s");
//                String kata1 = kata[0]; 
//                String kata2 = kata[1];
//                String namadepan = kata1 + " " + kata2;
//                String kata3 = kata[2];
//                String username = kata1 + kata3.substring(0,2);
//                System.out.println("Id Karyawan : Bantu bikin ya Tan :)");
//                System.out.println("Nama Depan : " + namadepan);
//                System.out.println("Nama Belakang : " + kata3);
//                System.out.println("Username : " + username);
//                System.out.println("Pass : " + emp.getPassword());
            }
        }
    }
//    MAIN CLASS
    public static void main(String[] args) {
        int pilih;
        String namaLengkap = "", pass = "";
        Main tampildata = new Main();

        Scanner scan = new Scanner(System.in).useDelimiter("\n");

        do {
            System.out.println("=====================");
            System.out.println("1. Add");
            System.out.println("2. View");
            System.out.println("3. Login");
            System.out.println("4. Keluar");
            System.out.println("=====================");
            System.out.print("Pilihan(1-3) : ");
            pilih = scan.nextInt();

            if (pilih == 1) {
                System.out.println("=================");
                System.out.println("Add");
                System.out.println("=================");
                System.out.print("Nama Lengkap   : ");
                namaLengkap = scan.next();
                System.out.print("Password       : ");
                pass = scan.next();

                tampildata.isiData(namaLengkap, pass);
            } else if (pilih == 2) {
                tampildata.showData();
            }
        } while (pilih != 4);
        System.out.println("Program Selesai");
    }
    
    
    
}
