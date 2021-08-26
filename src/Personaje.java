/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author loloj
 */
public abstract class Personaje {
    private final Dado d;
    protected String nombre;
    protected String raza;
    protected int vida;
    protected int fuerza;
    protected int agilidad;
    protected int constitucion;
    protected int numVictorias;
    protected int numBatallas;
    protected Arma arma;
    
    private final int fuerzaConMod;
    private int agilidadConMod;
    
   public Personaje (Dado d, Arma arma){
    this.d = d;
    this.fuerza = d.rollear();
    this.agilidad = d.rollear();
    this.constitucion = d.rollear();
    
    fuerzaConMod = mods(fuerza);
    agilidadConMod = mods(agilidad);
    this.vida = 15 + mods(constitucion);
    this.arma = arma;
 }  
   
   
   public static int mods(int n) {
        return (n - 10) / 2;
   }
   
   public void mod_fuerza(){
       mods(fuerza);
   }
   public void mod_constitucion(){
       mods(constitucion);
   }
   public void mod_agilidad(){
       mods(agilidad);
   }
   
   public void sumar_victoria(){
       numVictorias ++;
   }
   
   public void sumar_batalla(){
       numBatallas ++;
   }
   
   public void atacA (Personaje ataca){
        Dado d20 = new Dado(20);
        Dado d4 = new Dado(4);
        Dado d6 = new Dado(6);

            int daño = 0;
            int valord20 = d20.rollear();
            boolean esCritico = valord20 == 20;
           
                if (esCritico) {
                    System.out.println("**Golpe critico**");
                    daño = d6.rollear() + fuerzaConMod + d4.rollear();                  
                } else {
                    daño = d6.rollear() + fuerzaConMod;                   
                } 

            if(daño < 0){
                daño = 0;
                ataca.vida -= daño; 
            }else{
                ataca.vida -= daño;                 
            }
            
            System.out.println(this.nombre + " le hizo " + daño + " de daño a " + ataca.nombre);

            
   }
   
   public boolean seguis_vivo(){
    if(vida > 0) {
        return true; 
    }else{
        return false;
    }
 }

    public int getAgilidad() {
        return agilidad;
    }
   
    public int reiniciarVida() {
        return this.vida = 15 + mods(constitucion);
    }
   
    public static Personaje crear(Dado dado, Arma arma) {
        return new Personaje(dado, arma) {};
    }
   
    @Override
    public String toString() {
        return "RAZA = " + raza + "\nNOMBRE = " + nombre + "\nVIDA = " + vida + "\nFUERZA = " + fuerza + "\nAGILIDAD = " + agilidad + "\nCONSTITUCION = " + constitucion + "\nBATALLAS = " + numBatallas + "\nVICTORIAS = " + numVictorias;
    } 
}
