package org.dds.objects;

public class Station {
    private static int countStations = 0;

    private final int _stationID;
    private final String stationName;
    private final int x;
    private final int y;

    public Station() {
        _stationID          = countStations++;
        stationName         = "";
        x                   = 0;
        y                   = 0;
    }

    public Station(String stationName, int x, int y) {
        _stationID  = countStations++;
        this.stationName = stationName;
        this.x = x;
        this.y = y;

//        System.out.println("Station " + _stationID + " " + stationName + " created on " + x + " X and " + y + " Y");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getStationName() {
        return stationName;
    }

}
