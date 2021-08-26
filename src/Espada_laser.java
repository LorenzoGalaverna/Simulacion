/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Espada_laser extends Arma {
    Dado d6 = new Dado(6);
    public Espada_laser(Dado d) {
        super(d);
        super.presicion = 8;
        super.DañoArma = d6.rollear();
    }
    public int getDaño (){
        return DañoArma;
    }
}
