package states;

import model.Spieler;

public class Stunned extends Zustand {

    public Stunned(Spieler spieler) {
        super(spieler);
        name = "Bewegungsunfähig";
    }

    @Override
    public void heilen() {
        spieler.setZustand(new Verletzt(spieler));
        spieler.zeigeStatus();
    }

    @Override
    public void leichtVerletzen() {
        spieler.zeigeStatus();
    }

    @Override
    public void schwerVerletzen() {
        spieler.zeigeStatus();
    }
}
