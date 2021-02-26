package spielsteuerung;

import befehle.*;
import model.Spieler;

import java.util.LinkedList;

public class BefehlFactory {
	
	private Spieler spieler;
	private Parser parser;
	LinkedList<Befehl> befehlStack;
	
	public BefehlFactory(Spieler spieler, Parser parser, LinkedList befehlStack) {
		this.spieler = spieler;
		this.parser = parser;
		this.befehlStack = befehlStack;
	}
	
	public Befehl create(String b, String z) {
		if (b.equals("go")) {
			return new GehBefehl(z, spieler);
		}
		if (b.equals("eat")) {
			return new EssBefehl(z, spieler);
		}
		if (b.equals("take")) {
			return new NimmBefehl(z, spieler);
		}
		if (b.equals("drop")) {
			return new LegeAbBefehl(z, spieler);
		}
		if (b.equals("look")) {
			return new UmsehenBefehl(spieler);
		}
		if (b.equals("back")) {
			return new BackBefehl(befehlStack);
		}
		if (b.equals("help")) {
			return new HilfBefehl(parser);
		}
		if (b.equals("quit")) {
			return new BeendeBefehl();
		}

		return null;
	}
	
}
