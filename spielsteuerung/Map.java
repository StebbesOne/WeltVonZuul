package spielsteuerung;

import model.Gegenstand;
import model.Raum;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Map {
    private String name;
    protected HashMap<String, Raum> rooms = new HashMap<>();
    protected LinkedList<Gegenstand> items = new LinkedList<>();

    public Map() {
        items.add(new Gegenstand("Bogen", "Ein Bogen aus Holz", 0.5));
        Gegenstand muffin = new Gegenstand("Muffin", "Er schmeckt köstlich", 0.1);
        muffin.setMagic(true);
        items.add(muffin);
    }

    public Raum getRandomRoom() {
        int counter = 0;
        int randomNum = ThreadLocalRandom.current().nextInt(0, rooms.size() + 1);
        for(java.util.Map.Entry<String, Raum> r:rooms.entrySet()) {
            if (randomNum == counter) {
                return r.getValue();
            }
            counter++;
        }
        return null;
    }

    public void setItems() {
        for(Gegenstand g: items) {
            getRandomRoom().ablegen(g);
        }
    }

    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }

    abstract public void createRooms();

    abstract public Raum getBeginningRoom();

    abstract public void setExits();
}
