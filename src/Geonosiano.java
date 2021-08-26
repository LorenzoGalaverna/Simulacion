/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Geonosiano extends Personaje{
    public Geonosiano(Dado d, Arma arma){
        super(d, arma);
        super.fuerza += 2;
        super.agilidad += 3;
        super.constitucion -= 2;   
        super.raza = "Geonosiano";
    }

    
}
