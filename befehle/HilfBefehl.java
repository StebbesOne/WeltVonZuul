package befehle;

import spielsteuerung.Befehl;
import spielsteuerung.Parser;

public class HilfBefehl implements Befehl {

    private Parser parser;

    public HilfBefehl(Parser parser) {
        this.parser = parser;
    }

    @Override
    public void ausfuehren() {
        System.out.println("Sie haben sich verlaufen. Sie sind allein.");
        System.out.println("Sie irren auf dem Unigelände herum.");
        System.out.println();
        System.out.println("Ihnen stehen folgende Befehle zur Verfügung:");
        System.out.println(parser.getBefehle());
    }

    @Override
    public void back() {

    }
}
