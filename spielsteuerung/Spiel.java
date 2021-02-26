package spielsteuerung;

import befehle.BackBefehl;
import befehle.BeendeBefehl;
import befehle.HilfBefehl;
import befehle.UmsehenBefehl;
import exceptions.GegenstandNichtGefundenException;
import model.Raum;
import model.Spieler;
import model.Gegenstand;

import java.util.LinkedList;

/**
 * Dies ist die Hauptklasse der Anwendung "Die Welt von Zuul". "Die Welt von
 * Zuul" ist ein sehr einfaches, textbasiertes Adventure-Game. Ein Spieler kann
 * sich in einer Umgebung bewegen, mehr nicht. Das Spiel sollte auf jeden Fall
 * ausgebaut werden, damit es interessanter wird!
 * 
 * Zum Spielen muss eine Instanz dieser Klasse erzeugt werden und an ihr die
 * Methode "spielen" aufgerufen werden.
 * 
 * Diese Instanz erzeugt und initialisiert alle anderen Objekte der Anwendung:
 * Sie legt alle R�ume und einen Parser an und startet das Spiel. Sie wertet
 * auch die Befehle aus, die der Parser liefert, und sorgt f�r ihre Ausf�hrung.
 * 
 * @author Michael K�lling und David J. Barnes
 * @version 2008.03.30
 */

public class Spiel {
	private Parser parser;
	private Spieler spieler;
	private LinkedList<Befehl> befehlStack;

	/**
	 * Erzeuge ein Spiel und initialisiere die interne Raumkarte.
	 */
	public Spiel() {
		spieler = new Spieler();
		befehlStack = new LinkedList<>();
		parser = new Parser(spieler, befehlStack);
		initialisiereSpiel();
	}


	private void initialisiereSpiel() {
		MapFactory factory = new MapFactory();
		Map m = factory.getMap("schule");
		spieler.geheZu(m.getBeginningRoom());
	}

	/**
	 * Die Hauptmethode zum Spielen. L�uft bis zum Ende des Spiels in einer
	 * Schleife.
	 */
	public void spielen() {
		willkommenstextAusgeben();

		// Die Hauptschleife. Hier lesen wir wiederholt Befehle ein
		// und f�hren sie aus, bis das Spiel beendet wird.

		boolean beendet = false;
		while (!beendet) {
			Befehl befehl = parser.liefereBefehl();
			beendet = verarbeiteBefehl(befehl);
		}
		System.out.println("Danke für dieses Spiel. Auf Wiedersehen.");
	}

	/**
	 * Einen Begr��ungstext f�r den Spieler ausgeben.
	 */
	private void willkommenstextAusgeben() {
		System.out.println();
		System.out.println("Willkommen zu Zuul!");
		System.out.println("Zuul ist ein neues, unglaublich langweiliges Spiel.");
		System.out.println("Tippen sie 'help', wenn Sie Hilfe brauchen.");
		System.out.println();
		System.out.println(spieler.getAktuellerRaum().gibLangeBeschreibung());
	}

	/**
	 * Verarbeite einen gegebenen Befehl (f�hre ihn aus).
	 * 
	 * @param befehl Der zu verarbeitende Befehl.
	 * @return 'true', wenn der Befehl das Spiel beendet, 'false' sonst.
	 */
	private boolean verarbeiteBefehl(Befehl befehl) {
		befehl.ausfuehren();

		if (!(befehl instanceof BackBefehl) && !(befehl instanceof HilfBefehl) && !(befehl instanceof UmsehenBefehl)) {
			befehlStack.push(befehl);
		}

		if (befehl instanceof BeendeBefehl) {
			return true;
		}
		return false;
	}


}
