/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Punto4;

//CAMILO ANDRES GIL BALLEN - cgilb
//JUAN DIEGO MEDINA NARANJO - jmedinan

class Person {
    private String nombre;
    private String apellido;
    private int numDocumento;

    public Person(String nombre, String apellido, int numDocumento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numDocumento = numDocumento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(int numDocumento) {
        this.numDocumento = numDocumento;
    }
    
    @Override
    public String toString(){
        return numDocumento + " " + nombre + " " + apellido;
    }
}
