/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Wookie extends Personaje{
    public Wookie(Dado d, Arma arma){
        super(d, arma);
        super.fuerza += 3;
        super.agilidad -= 2;
        super.constitucion += 2;   
        super.raza = "wookie";
    }
}
