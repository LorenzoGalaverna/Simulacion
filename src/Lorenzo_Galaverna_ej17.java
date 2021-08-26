/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


/**
 *
 * @author loloj
 */
public class Lorenzo_Galaverna_ej17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Dado d20 = new Dado(20);
        
        Arma espada_laser = new Espada_laser(d20);
        Arma pistola_laser = new Pistola_laser(d20);
        Arma ballesta_laser = new Ballesta_laser(d20);
        Arma cachiporra_laser = new Cachiporra_laser(d20);
        
        MyScanner in = new MyScanner();
        
        Personaje personaje;
        Personaje raza;
        
        Personaje personaje1;
        Personaje personaje2;
        
        
        
        System.out.println(
            "                   _______________________________\n" +
            "          ________|                               |_______\n" +
            "          \\        | ☢Welcome To Chernobyl War☢ |      /\n" +
            "           \\       |                             |     /\n" +  
            "           /      |_______________________________|    \\\n" +
            "          /__________)                        (__________\\\n" +
                                     "		  ");
        System.out.println(
                "     ╔════════════════════════════════════╗ \n" +
                "     ║A continuacion se realizara una simulacion de una batalla║ \n" +
                "     ╚════════════════════════════════════╝  ");
        
        
        System.out.println("------------------------------");
        System.out.println("-        ESTADISTICAS        -");
        System.out.println("------------------------------");
        
        Personaje Jedi = new Jedi(d20, espada_laser);
        System.out.println(Jedi.toString());       
        System.out.println("-------------------------");       
        Personaje Geonosiano = new Geonosiano(d20, pistola_laser);
        System.out.println(Geonosiano.toString());        
        
        System.out.println("-------------------------");
        System.out.println("-        Combate        -");
        System.out.println("-------------------------");
        
        Combate simulacion = new Combate(Jedi, Geonosiano);
        simulacion.pelea();
        
        System.out.println(
                "     ╔══════════════════════╗ \n" +
                "     ║A continuacion comenzara la batalla║ \n" +
                "     ╚══════════════════════╝  ");
        boolean seguir = true;
        List<Personaje> personajes = new ArrayList<>(Arrays.asList(Geonosiano, Jedi));
        
        do {
            int opcion = in.scanOption("Batalla","Crear","Salir");

            switch (opcion) {
                case 1:
                    String nombre = in.scanString("Escriba el nombre del personaje");
                    Arma arma = in.scanOption("Seleccione el arma para su personaje", pistola_laser, espada_laser, cachiporra_laser, ballesta_laser);
                    personaje = in.scanOption("Seleccione la raza del personaje",
                            new Jedi(d20, arma),
                            new Geonosiano(d20, arma),
                            new Wookie(d20, arma),
                            new Stormtrooper(d20, arma));
                    personajes.add(personaje);
                    break;
                case 2:
                    personaje1 = in.scanOption("Seleccione el peleador 1", personajes.toArray(Personaje[]::new));
                    personaje2 = in.scanOption("Seleccione el peleador 2", personajes.toArray(Personaje[]::new));
                    Combate real = new Combate(personaje1, personaje2);
                    real.pelea();
                    break;
                case 3:
             seguir = false;
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (seguir);

    }

    
        private static class MyScanner {
        private final PrintStream out;
        private final Scanner sc;

        public MyScanner() {
            this.out = System.out;
            this.sc = new Scanner(System.in);
        }

        public <T> T scanOption(String mensaje, T... opciones) {
            return opciones[scanOption(mensaje, Arrays.stream(opciones).map(o -> o.getClass().getSimpleName() + " ---> " + o).toArray(String[]::new)) -1];
        }

        public int scanOption(String mensaje, String... opciones) {
            printMensaje(mensaje);
            int opcion;
            boolean opcionValida;
            do {
                for (int i = 0; i < opciones.length; i++) {
                    out.println((i + 1) + ". " + opciones[i]);
                }
                opcion = sc.nextInt();
                opcionValida = opcion >= 1 && opcion <= opciones.length;
                if (!opcionValida) {
                    out.println("Opcion " + opcion + " no valida.");
                }
            } while (!opcionValida);
            return opcion;
        }

        private void printMensaje(String mensaje) {
            out.println("---" + mensaje + "---");
        }

        public String scanString(String mensaje) {
            printMensaje(mensaje);
            Pattern delimiter = sc.delimiter();
            sc.useDelimiter("\\r\\n|[\\n\\x0B\\x0C\\r\\u0085\\u2028\\u2029]"); // https://stackoverflow.com/questions/4058912/scanner-doesnt-read-whole-sentence-difference-between-next-and-nextline-o
            String s = sc.next();
            sc.useDelimiter(delimiter);
            return s;
        }

        }
}
        
    
    
