package org.dds.objects;

public class Station {

    private static int _stationID = 0;
    private String stationName;
    private double x, y;
    private int tracksNumber, currentTrainNumber;
    private double maxStationCapacity;
    private int avgPassengerExchangeTime;

    public Station() {
        stationName         = "";
        x                   = 0.0;
        y                   = 0.0;
        tracksNumber        = 0;
        currentTrainNumber  = 0;
        maxStationCapacity  = 0.0F;
        avgPassengerExchangeTime = 2;
    }

    public Station(String stationName, double x, double y, int tracksNumber, int avgPassengerExchangeTime) {
        _stationID++;
        this.stationName = stationName;
        this.x = x;
        this.y = y;
        this.tracksNumber = tracksNumber;

        currentTrainNumber = 0; // < maxStationCapacity - 1
        this.avgPassengerExchangeTime = avgPassengerExchangeTime;

        maxStationCapacity = ((double) 60 / (avgPassengerExchangeTime + 2) * (tracksNumber - 1));

        System.out.println("Utworzono stację " + _stationID + " " + stationName + " na pozycji " +
                x + " " + y + " z maksymalną przepustowością na poziomie " + maxStationCapacity + " cykli na godzinę.");
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getStationID() {
        return _stationID;
    }

    public String getStationName() {
        return stationName;
    }

}
