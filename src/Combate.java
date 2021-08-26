/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Combate {
    
    private Personaje personaje1;
    private Personaje personaje2;
    
    public Combate(Personaje personaje1, Personaje personaje2) {
        this.personaje1 = personaje1;
        this.personaje2 = personaje2;
        
        personaje1.reiniciarVida();
        personaje2.reiniciarVida();
    }
    
    public void pelea() {
        personaje2.sumar_batalla();
        personaje1.sumar_batalla();
        
        
        while(personaje1.seguis_vivo() && personaje2.seguis_vivo()){
            
            if (personaje1.getAgilidad() > personaje2.getAgilidad()) {
                personaje1.atacA(personaje2);
                personaje2.atacA(personaje1);
            } else {
                personaje2.atacA(personaje1);
                personaje1.atacA(personaje2);
            }
        }
        
         if (personaje1.seguis_vivo()) {
            personaje1.sumar_victoria();
            System.out.println("✸ El ganador es: " + personaje1.nombre + " ✸");
        } else {
            personaje2.sumar_victoria();
            System.out.println("✸ El ganador es: " + personaje2.nombre + " ✸");
        }
    }
 }
    

