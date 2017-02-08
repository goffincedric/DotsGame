package be.kdg.Dots.Model;

/**
 * @author Thomas Verhoeven
 * @version 1.0 8/02/2017 12:18
 */
public class test {

    public static void main(String[] args) {
        Dots game = new Dots();
        Dot dot1 = new Dot(1,1);
        Dot dot2 = new Dot(1,3);

        for (Kleuren kleur : Kleuren.values()) {
            System.out.println(kleur.name() + "    R: " + kleur.getRed() + " G: " + kleur.getGreen() + " B: " + kleur.getBlue());
        }

        /*System.out.println(java.util.Arrays.asList(Kleuren.values().toString()));



        System.out.println(dot1.toString());
        System.out.println(dot2.toString());*/

        System.out.println();

        Level level = new Level();
        System.out.println(level.toString());

        for (int i = 0; i < 20; i++) {
            level.nextLevel();
            System.out.println(level.toString());
        }
    }




}
