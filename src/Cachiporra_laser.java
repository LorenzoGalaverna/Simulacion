/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Cachiporra_laser extends Arma{
    Dado d7 = new Dado(7);
    public Cachiporra_laser(Dado d) {
        super(d);
        super.presicion = 11;
        super.DañoArma = d7.rollear();
    }
    public int getDaño (){
        return DañoArma;
    }
}
