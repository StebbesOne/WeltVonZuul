package spielsteuerung;

public abstract class MapManager {

    public Map getMap(String type) {
        Map map = createMap(type);
        map.createRooms();
        map.setExits();
        map.setItems();
        return map;
    }

    abstract protected Map createMap(String type);

}
