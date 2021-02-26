package states;

import model.Spieler;

public class Gesund extends Zustand {

    public Gesund(Spieler spieler) {
        super(spieler);
        name = "Gesund";
    }

    @Override
    public void heilen() {
        spieler.zeigeStatus();
    }

    @Override
    public void leichtVerletzen() {
        spieler.setZustand(new Verletzt(spieler));
        spieler.zeigeStatus();
    }

    @Override
    public void schwerVerletzen() {
        spieler.setZustand(new Stunned(spieler));
        spieler.zeigeStatus();
    }
}
