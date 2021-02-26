package befehle;

import exceptions.GegenstandNichtGefundenException;
import model.Spieler;
import spielsteuerung.Befehl;

public class UmsehenBefehl implements Befehl {

	private Spieler spieler;

	public UmsehenBefehl(Spieler spieler) {
		this.spieler = spieler;
	}
	
	@Override
	public void ausfuehren() {
		System.out.println(spieler.getAktuellerRaum().gibLangeBeschreibung());
	}

	@Override
	public void back() {

	}

}
