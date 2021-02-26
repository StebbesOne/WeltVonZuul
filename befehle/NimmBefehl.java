package befehle;

import exceptions.GegenstandNichtGefundenException;
import model.Spieler;
import spielsteuerung.Befehl;

public class NimmBefehl implements Befehl {

	private Spieler spieler;
	private String ziel;
	
	public NimmBefehl(String ziel, Spieler spieler) {
		this.ziel = ziel;
		this.spieler = spieler;
	}
	
	@Override
	public void ausfuehren() {
		try {
			spieler.gegenstandAufnehmen(spieler.getAktuellerRaum().entferneGegenstand(ziel));
		} catch (GegenstandNichtGefundenException e) {
			e.printStackTrace();
		}
		System.out.println(spieler.zeigeStatus());
	}

	@Override
	public void back() {
		try {
			spieler.getAktuellerRaum().ablegen(spieler.gegenstandAblegen(ziel));
		} catch (GegenstandNichtGefundenException e) {
			e.printStackTrace();
		}
		System.out.println(spieler.zeigeStatus());
	}

}
