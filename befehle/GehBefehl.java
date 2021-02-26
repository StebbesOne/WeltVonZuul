package befehle;

import model.Raum;
import model.Spieler;
import spielsteuerung.Befehl;

public class GehBefehl implements Befehl{

	private Spieler spieler;
	private String ziel;
	
	public GehBefehl(String ziel, Spieler spieler) {
		this.ziel = ziel;
		this.spieler = spieler;
	}
	
	public void ausfuehren() {
		geh(ziel);
	}

	@Override
	public void back() {
		geh(invert(ziel));
	}

	private void geh(String z) {
		Raum naechsterRaum = null;
		naechsterRaum = spieler.getAktuellerRaum().getAusgang(z);
		if (naechsterRaum == null) {
			System.out.println("Dort ist keine T�r!");
		} else {
			spieler.geheZu(naechsterRaum);
			System.out.println(spieler.getAktuellerRaum().gibLangeBeschreibung());
		}
	}

	private String invert(String richtung) {
		if (richtung.equals("north")) {
			return "south";
		}
		if (richtung.equals("south")) {
			return "north";
		}
		if (richtung.equals("west")) {
			return "east";
		}
		if (richtung.equals("east")) {
			return "west";
		}
		if (richtung.equals("up")) {
			return "down";
		}
		if(richtung.equals("down")) {
			return "up";
		}
		return null;
	}

}
