/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manipulasistring_dia_nathan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Dia and Nathan
 */
public class Main {
/**
 * Ini merupakan list untuk menyimpan data employees kemudian ditampung dalam variable tampung
 */
    LinkedList<Employees> tampung;
    private static final AtomicInteger ID = new AtomicInteger(0);
    
    public Main() {
        tampung = new LinkedList<>();
    }

    public void isiData(String namaLengkap, String password) {

//      manipulasi string disini
/**
 * Ini merupakan fungsi untuk manipulasi string.
 * variable nama lengkap akan dipecah menjadi array yang dipisahkan dengan spasi.
 * jika panjang array split memiliki panjang kurang dari 1 maka nama depan dan nama belakang sama.
 * jika panjang array split memiliki panjang lebih dari satu maka lastName didapat dari index array terakhir.
 * lalu firstName didapat dari index array awal ditambah dengan index array berikutnya kemudian digabung dan diberi spasi.
 */
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
        
//      jika index split > 2 maka username otomatis mengambil index pertama dan 2 huruf lastname
        username = split[0] + lastName.substring(0, 2);
//        ngecek apakah username sudah ada di dalam employee
        for (int i = 0; i < tampung.size(); i++) {
                if(tampung.get(i).getUsername().equals(username)){
                    username = split[0] + split[split.length-i-2].substring(0,2);
//                    System.out.println("username sudah ada");
                }
            }
        tampung.add(new Employees(firstName, lastName, username, password, ID.incrementAndGet()));
        System.out.println("--Data ditambah--");

    }
/**
 * ini merupakan fungsi untuk menampilkan seluruh data employees yang berada dalam kelas employees
 */
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
                System.out.println("-----------------------------------");
            }
        }
    }
/**
 * fungsi login digunakan untuk pengecekan username dan password yang sudah kita add sebelumnya.
 */
    public void login() {
        Scanner scanner = new Scanner(System.in);
        String scanUsername, scanPass;

        System.out.println("---------------");
        System.out.print("Username : ");
        scanUsername = scanner.next();
        System.out.print("Password : ");
        scanPass = scanner.next();

        if (tampung.isEmpty()) {
            System.out.println("--------------");
            System.out.println("Data tidak ada");
            System.out.println("--------------");
        } else {
            System.out.println("--------------");
            System.out.println("Data employees");
            System.out.println("--------------");
/**
 * for digunakan untuk memeriksa data yang berada dalam list.
 * jika username dan password di dalam list sesuai dengan scanUsername dan scanPass yg kita isikan maka akan berhasil, jika berbeda makan akan gagal
 * dan jika username dan password tidak sama maka akan mencetak data tidak ditemukan.
 */
            
            for (int i = 0; i < tampung.size(); i++) {
                if(tampung.get(i).getUsername().equals(scanUsername)){
                    boolean cekPass = BCrypt.checkpw(scanPass, tampung.get(i).getPassword());
                    if(cekPass){
                        System.out.println("LOGIN BERHASIL !!");
                    } else {
                        System.out.println("LOGIN GAGAL !!");
                    } 
                }else{
                    System.out.println("DATA TIDAK DITEMUKAN!!!");
                }
            }
        }
    }

//    MAIN CLASS
    public static void main(String[] args) {
        int pilih=0;
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
            try {
                pilih = scan.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("TOLONG DI ISI DENGAN INTEGER ALIAS ANGKA BOS!");
                scan.next();
                continue;
            }

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
            else if(pilih == 3){
                tampildata.login();
            }
        } while (pilih != 4);
        System.out.println("Program Selesai");
    }
    
    
    
}
