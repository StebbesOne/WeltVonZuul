package model;
import java.util.HashMap;
import java.util.Map;

import exceptions.GegenstandNichtGefundenException;

/**
 * Diese Klasse modelliert R�ume in der Welt von Zuul.
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des Spiels.
 * Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden. M�gliche Ausg�nge
 * liegen im Norden, Osten, S�den und Westen. F�r jede Richtung h�lt ein Raum
 * eine Referenz auf den benachbarten Raum.
 * 
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Raum {
	StringBuilder builder = new StringBuilder();
	private String beschreibung;
	private HashMap<String, Raum> ausgaenge;
	private HashMap<String, Gegenstand> gegenstaende;

	/**
	 * Erzeuge einen Raum mit einer Beschreibung. Ein Raum hat anfangs keine
	 * Ausg�nge.
	 * 
	 * @param beschreibung enth�lt eine Beschreibung in der Form "in einer K�che"
	 *                     oder "auf einem Sportplatz".
	 */
	public Raum(String beschreibung) {
		this.beschreibung = beschreibung;
		ausgaenge = new HashMap<String, Raum>();
		gegenstaende = new HashMap<String, Gegenstand>();
	}

	/**
	 * Definiere die Ausg�nge dieses Raums. Jede Richtung f�hrt entweder in einen
	 * anderen Raum oder ist 'null' (kein Ausgang).
	 *
	 */
	public void setAusgang(String richtung, Raum nachbar) {
		ausgaenge.put(richtung, nachbar);
	}

	public Raum getAusgang(String ausgang) {
		return ausgaenge.get(ausgang);
	}

	public String ausgaengeToString() {
		builder.delete(0, builder.length());
		builder.append("\n");
		appendIfNotNull("north");
		appendIfNotNull("south");
		appendIfNotNull("east");
		appendIfNotNull("west");
		appendIfNotNull("up");
		appendIfNotNull("down");
		return builder.toString();
	}

	private void appendIfNotNull(String str) {
		Raum raum = ausgaenge.get(str);
		if (raum != null) {
			builder.append(str);
			builder.append(" - ");
			builder.append(raum.beschreibung);
			builder.append("\n");
		}
	}
	
	public Gegenstand entferneGegenstand(String name) throws GegenstandNichtGefundenException {
		Gegenstand g = gegenstaende.get(name);
		if (g != null) {
			gegenstaende.remove(name);
			return g;
		}
		throw new GegenstandNichtGefundenException("Diesen Gegenstand gibt es hier nicht!");
	}
	
	public void ablegen(Gegenstand g) {
		gegenstaende.put(g.getName(), g);
	}

	/**
	 * @return Die Beschreibung dieses Raums.
	 */
	public String gibBeschreibung() {
		return beschreibung;
	}
	
	public String gibLangeBeschreibung() {
		StringBuilder b = new StringBuilder();
		b.append("Sie sind ")
		.append(beschreibung)
		.append("\n")
		.append("Ausg�nge: \n")
		.append(ausgaengeToString())
		.append("\n")
		.append("Gegenst�nde: \n");
		for(Map.Entry<String, Gegenstand> entry: gegenstaende.entrySet()) {
			b.append(entry.getValue().toString())
			.append("\n");
		}
		return b.toString();
	}

}
