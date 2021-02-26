package maps;

import model.Raum;
import spielsteuerung.Map;

public class MayaMap extends Map {

    @Override
    public void createRooms() {
        // die Räume erzeugen
        rooms.put("marktplatz", new Raum("auf dem Marktplatz"));
        rooms.put("tempelpyramide", new Raum("in einer Tempelpyramide"));
        rooms.put("taverne", new Raum("in der Taverne am Marktplatz"));
        rooms.put("opferstaette", new Raum("an einer Opferstaette"));
        rooms.put("wohnhuette", new Raum("in einer Wohnhuette"));
        rooms.put("dschungel", new Raum("im Dschungel"));
        rooms.put("geheimgang", new Raum("in einem Geheimgang"));
        rooms.put("hoehle", new Raum("in einer Höhle"));
        rooms.put("strand", new Raum("am Strand"));
        rooms.put("keller", new Raum("im Keller"));
        rooms.put("zaubererRaum", new Raum("Im Zauberer Zimmer."));
    }

    @Override
    public Raum getBeginningRoom() {
        return rooms.get("marktplatz");
    }

    @Override
    public void setExits() {
        Raum marktplatz = rooms.get("marktplatz");
        Raum tempelpyramide = rooms.get("tempelpyramide");
        Raum taverne = rooms.get("taverne");
        Raum opferstaette = rooms.get("opferstaette");
        Raum wohnhuette = rooms.get("wohnhuette");
        Raum dschungel = rooms.get("dschungel");
        Raum geheimgang = rooms.get("geheimgang");
        Raum hoehle = rooms.get("hoehle");
        Raum strand = rooms.get("strand");
        Raum keller = rooms.get("keller");
        Raum zaubererRaum = rooms.get("zaubererRaum");

        marktplatz.setAusgang("north", taverne);
        marktplatz.setAusgang("east", tempelpyramide);
        marktplatz.setAusgang("west", opferstaette);
        tempelpyramide.setAusgang("north", wohnhuette);
        tempelpyramide.setAusgang("west", marktplatz);
        tempelpyramide.setAusgang("down", keller);
        tempelpyramide.setAusgang("up", zaubererRaum);
        taverne.setAusgang("south", marktplatz);
        taverne.setAusgang("east", wohnhuette);
        opferstaette.setAusgang("east", marktplatz);
        opferstaette.setAusgang("down", hoehle);
        wohnhuette.setAusgang("south", tempelpyramide);
        wohnhuette.setAusgang("east", dschungel);
        wohnhuette.setAusgang("west", taverne);
        dschungel.setAusgang("west", wohnhuette);
        geheimgang.setAusgang("east", keller);
        geheimgang.setAusgang("west", hoehle);
        hoehle.setAusgang("south", strand);
        hoehle.setAusgang("east", geheimgang);
        hoehle.setAusgang("up", opferstaette);
        strand.setAusgang("north", hoehle);
        keller.setAusgang("west", geheimgang);
        keller.setAusgang("up", tempelpyramide);
        zaubererRaum.setAusgang("down", tempelpyramide);
    }
}
