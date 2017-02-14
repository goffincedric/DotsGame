package be.kdg.Dots.Model;

/**
 * @author Thomas Verhoeven
 * @version 1.0 8/02/2017 12:18
 */
public class test {

    public static void main(String[] args) {
        Speler speler = new Speler();
        Level level = new Level();
        Lijn lijn = new Lijn();


        Dots dotsGame = new Dots();


        for (Kleuren kleur : Kleuren.values()) {
            System.out.println(kleur.name() + "    R: " + kleur.getRed() + " G: " + kleur.getGreen() + " B: " + kleur.getBlue());
        }

        /*System.out.println(java.util.Arrays.asList(Kleuren.values().toString()));



        System.out.println(dot1.toString());
        System.out.println(dot2.toString());*/

        System.out.println();


        // System.out.println(game.getLevel().toString());

        /*for (int i = 0; i < 20; i++) {
            game.getLevel().nextLevel();
            System.out.println(game.getLevel().toString());
        }*/
    }


}
