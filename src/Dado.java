/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public class Dado {
    private final int caras;

    public Dado(int caras) {
        this.caras = caras;
    }

    public int rollear() {
        int resultado = (int) (Math.floor(Math.random()*caras)+1);
        return resultado;
    }
}
