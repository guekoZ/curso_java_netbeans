/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.java.com.mycompany.estudiojava;

/**
 *
 * @author gueko
 */
public class pruebaMariaDB {
    
    public static void main(String[] args) {
        dbConection dbc = new dbConection();
        dbc.conectar();
        System.out.println("Este el cambio hecho en la pc");
    } 
    
}
