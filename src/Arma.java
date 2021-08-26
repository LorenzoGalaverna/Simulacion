/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Optional;

/**
 *
 * @author loloj
 */
public abstract class Arma {
    public Arma (Dado d){
    this.d = d;
 }
    private final Dado d;
    protected final Dado d6 = new Dado(6);
    protected int presicion;
    protected int DañoArma;
    
    public int presicion(int n){
        if (n >= presicion ){
            presicion = n;
        } else {
            presicion = 0;
        }
        return presicion;
    }
    
    public boolean dispara(int n){
        if (presicion == 0){
            return true;
        }else{
            return false;
        }
    }
    
 
   
}
