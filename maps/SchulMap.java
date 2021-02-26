package maps;

import model.Raum;
import spielsteuerung.Map;

public class SchulMap extends Map {

    @Override
    public void createRooms() {
        // die R�ume erzeugen
        rooms.put("klassenzimmer", new Raum("in der Klasse"));
        rooms.put("lehrerzimmer", new Raum("im Lehrerzimmer"));
        rooms.put("raucherecke", new Raum("in der Raucherecke"));
        rooms.put("aula", new Raum("in der Aula"));
        rooms.put("flur", new Raum("im Flur"));
    }

    @Override
    public Raum getBeginningRoom() {
        return rooms.get("flur");
    }

    @Override
    public void setExits() {
        Raum klassenzimmer = rooms.get("klassenzimmer");
        Raum lehrerzimmer = rooms.get("lehrerzimmer");
        Raum raucherecke = rooms.get("raucherecke");
        Raum aula = rooms.get("aula");
        Raum flur = rooms.get("flur");

        klassenzimmer.setAusgang("north", flur);
        aula.setAusgang("east", flur);
        lehrerzimmer.setAusgang("west", flur);
        raucherecke.setAusgang("up", flur);

        flur.setAusgang("south", klassenzimmer);
        flur.setAusgang("west", aula);
        flur.setAusgang("east", lehrerzimmer);
        flur.setAusgang("down", raucherecke);

    }
}
