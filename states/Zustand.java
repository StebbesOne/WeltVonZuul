package states;

import model.Spieler;

public abstract class Zustand {

    Spieler spieler;
    String name;

    public Zustand(Spieler spieler) {
        this.spieler = spieler;
    }

    public abstract void heilen();
    public abstract void leichtVerletzen();
    public abstract void schwerVerletzen();

    public String getName() {
        return name;
    }

}
