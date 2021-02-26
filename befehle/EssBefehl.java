package befehle;

import exceptions.GegenstandNichtGefundenException;
import model.Gegenstand;
import model.Spieler;
import spielsteuerung.Befehl;
import states.Zustand;

public class EssBefehl implements Befehl {

    private String ziel;
    private Spieler spieler;
    private Gegenstand gegenstand;
    private Zustand ursprungsZustand;

    public EssBefehl(String ziel, Spieler spieler) {
        this.ziel = ziel;
        this.spieler = spieler;
    }

    @Override
    public void ausfuehren() {
        try {
            gegenstand = spieler.gegenstandAblegen(ziel);
            if (gegenstand != null) {
                if (gegenstand.isMagic()) {
                    spieler.setTragkraft(spieler.getTragkraft() + 2);
                }
            }
            ursprungsZustand = spieler.getZustand();
            spieler.getZustand().heilen();
            System.out.println(spieler.zeigeStatus());
        } catch (GegenstandNichtGefundenException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void back() {
        if (gegenstand.isMagic()) {
            spieler.setTragkraft(spieler.getTragkraft() - 2);
        }
        spieler.setZustand(ursprungsZustand);
        spieler.gegenstandAufnehmen(gegenstand);
        System.out.println(spieler.zeigeStatus());
    }
}
