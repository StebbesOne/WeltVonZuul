package spielsteuerung;

import maps.MayaMap;
import maps.SchulMap;

public class MapFactory extends MapManager{
    protected Map createMap(String type) {
        if (type.equals("maya")) {
            return new MayaMap();
        }
        if (type.equals("schule")) {
            return new SchulMap();
        }
        return null;
    }
}
