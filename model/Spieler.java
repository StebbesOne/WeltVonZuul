package model;
import java.util.LinkedList;

import exceptions.GegenstandNichtGefundenException;
import states.Gesund;
import states.Stunned;
import states.Zustand;

public class Spieler {
	private Raum aktuellerRaum;
	private int tragkraft;
	private LinkedList<Gegenstand> gegenstaende;
	private Zustand zustand;
	
	public Spieler() {
		zustand = new Gesund(this);
		gegenstaende = new LinkedList<Gegenstand>();
		tragkraft = 10;
	}
	
	public Raum getAktuellerRaum() {
		return aktuellerRaum;
	}
	
	public void geheZu(Raum raum) {
		aktuellerRaum = raum;
	}

	public int getTragkraft() {
		return tragkraft;
	}
	
	public void setTragkraft(int i) {
		tragkraft = i;
	}
	
	public boolean gegenstandAufnehmen(Gegenstand g) {
		if (isAufnehmenMoeglich(ermittleGewicht())) {
			gegenstaende.add(g);	
			return true;
		}
		return false;
	}
	
	public Gegenstand gegenstandAblegen(String name) throws GegenstandNichtGefundenException {
		for(Gegenstand g: gegenstaende) {
			if (g.getName().equals(name)) {
				gegenstaende.remove(g);
				return g;
			}
		}
		throw new GegenstandNichtGefundenException("Du hast diesen Gegenstand nicht!");
	}
	
	public String zeigeStatus() {
		StringBuilder b = new StringBuilder();
		b
		.append("Zustand : \t")
		.append(zustand.getName())
		.append("\n")
		.append("Tragkraft: ")
		.append(tragkraft)
		.append("\n")
		.append("Aufgenommene Gegenstände: ")
		.append("\n");
		
		for(Gegenstand g:gegenstaende) {
			b
			.append(g.getName())
			.append(", \t")
			.append(g.getGewicht())
			.append("\n");
		}
		
		b
		.append("Aufgenommenes Gewicht: ")
		.append(ermittleGewicht());
		return  b.toString();
	}
	
	private double ermittleGewicht() {
		double gewicht = 0;
		for(Gegenstand g: gegenstaende) {
			gewicht += g.getGewicht();
		}
		return gewicht;
	}
	
	private boolean isAufnehmenMoeglich(double gewicht) {
		if (gewicht < tragkraft) {
			return true;
		}
		return false;
	}

	public Zustand getZustand() {
		return zustand;
	}

	public void setZustand(Zustand zustand) {
		this.zustand = zustand;
	}
	
}
