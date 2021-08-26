/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Pistola_laser extends Arma{
    Dado d5 = new Dado(5);
    public Pistola_laser(Dado d) {
        super(d);
        super.presicion = 13;
        super.DañoArma = d5.rollear();
    }
}
