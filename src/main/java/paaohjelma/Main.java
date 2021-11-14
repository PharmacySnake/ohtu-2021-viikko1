package paaohjelma;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {
        Varasto olutta = new Varasto(100.0, 20.2);

        System.out.println("Luonnin jälkeen:\nOlutvarasto: " + olutta+"\nOlutgetterit:\ngetSaldo()     = " + olutta.getSaldo()+"\ngetTilavuus    = " + olutta.getTilavuus()+"\npaljonkoMahtuu = " + olutta.paljonkoMahtuu()+"\nMehusetterit:\nLisätään 50.7");
        System.out.println("Virhetilanteita:\nnew Varasto(-100.0);");
        Varasto huono = new Varasto(-100.0);
        System.out.println(huono);
    }
}
