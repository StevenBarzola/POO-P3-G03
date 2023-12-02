/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo.evento;
import modelo.participante.*;
import java.util.ArrayList;


/**
 *
 * @author User
 */

public class Sistema{
  
  public static ArrayList<Feria> ferias=new ArrayList<>();//Lista de todas las ferias
  public static ArrayList<Auspiciante> auspiciantes= new ArrayList<>();
  public static ArrayList<Emprendedor> emprendedores= new ArrayList<>();
  
  
  public static void registrarEmp(Persona p, String descripcionServicios) {
  //Este método registra los emprendedores en la lista de emprendedores si es que no se encuentra allí.
    Emprendedor emp=(Emprendedor)p;
    for (int e=0; e<Sistema.emprendedores. size(); e++) {
      if (emprendedores.get(e).getNumld().equals(emp.getNumld())) { 
        System.out.println("El Emprendedor ya se encuentra registrado");
        }
      else {
        emp.setDescripcionServicios(descripcionServicios);
        emprendedores.add(emp);
        }
    e=Sistema.emprendedores. size();
    }
   } 

}