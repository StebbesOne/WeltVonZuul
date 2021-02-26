package states;

import model.Spieler;

public class Verletzt extends Zustand {

    public Verletzt(Spieler spieler) {
        super(spieler);
        name = "Verletzt";
    }

    @Override
    public void heilen() {
        spieler.setZustand(new Gesund(spieler));
        spieler.zeigeStatus();
    }

    @Override
    public void leichtVerletzen() {
        spieler.setZustand(new Stunned(spieler));
        spieler.zeigeStatus();
    }

    @Override
    public void schwerVerletzen() {
        spieler.setZustand(new Stunned(spieler));
        spieler.zeigeStatus();
    }
}
