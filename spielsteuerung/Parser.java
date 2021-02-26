package spielsteuerung;
import model.Spieler;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Dieser Parser liest Benutzereingaben und wandelt sie in
 * Befehle für das Adventure-Game um. Bei jedem Aufruf
 * liest er eine Zeile von der Konsole und versucht, diese als
 * einen Befehl aus bis zu zwei Wörtern zu interpretieren. Er
 * liefert den Befehl als ein Objekt der Klasse Befehl zurück.
 * 
 * Der Parser verfügt über einen Satz an bekannten Befehlen. Er
 * vergleicht die Eingabe mit diesen Befehlen. Wenn die Eingabe
 * keinen bekannten Befehl enthält, dann liefert der Parser ein als 
 * unbekannter Befehl gekennzeichnetes Objekt zurück.
 * 
 * @author  Michael Kölling und David J. Barnes
 * @version 2008.03.30
 */
public class Parser 
{
    private Befehlswoerter befehle;  // hält die gültigen Befehlswörter
    private Scanner leser;         // Lieferant für eingegebene Befehle
    private BefehlFactory befehlFactory;
    private LinkedList<Befehl> befehlStack;

    /**
     * Erzeuge einen Parser, der Befehle von der Konsole einliest.
     */
    public Parser(Spieler spieler, LinkedList befehlStack)
    {
        this.befehle = new Befehlswoerter();
        this.leser = new Scanner(System.in);
        this.befehlStack = befehlStack;
        this.befehlFactory = new BefehlFactory(spieler, this, befehlStack);
    }

    /**
     * @return Den nächsten Befehl des Benutzers.
     */
    public Befehl liefereBefehl() 
    {
        String eingabezeile;   // für die gesamte Eingabezeile
        String wort1 = null;
        String wort2 = null;

        System.out.print("> ");     // Eingabeaufforderung

        eingabezeile = leser.nextLine();
        
        // Finde bis zu zwei Wörter in der Zeile
        Scanner zerleger = new Scanner(eingabezeile);
        if(zerleger.hasNext()) {
            wort1 = zerleger.next();     // erstes Wort lesen
            if (zerleger.hasNext()) {
                wort2 = zerleger.next();    // zweites Wort lesen
                // Hinweis: Wir ignorieren den Rest der Eingabezeile.
            }
        }
        
        // Jetzt prüfen, ob der Befehl bekannt ist. Wenn ja, erzeugen
        // wir das passende Befehl-Objekt. Wenn nicht, erzeugen wir
        // einen unbekannten Befehl mit 'null'.
        if(befehle.istBefehl(wort1)) {
            Befehl b = befehlFactory.create(wort1, wort2);
            return b;
        }
        else {
            System.out.println("Das ist kein gültiger Befehl.");
            return befehlFactory.create("help", "");
        }
    }
    
    public String getBefehle() {
    	return befehle.getBefehlswoerter();
    }

}
