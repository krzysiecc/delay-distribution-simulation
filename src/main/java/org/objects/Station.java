package org.objects;

import org.framework.Coordinates;

public class Station {

    private int _stationID;
    private int x, y;
    private int tracksNumber, currentTrainNumber;
    private double maxStationCapacity;
    private int avgPassengerExchangeTime;

    public Station() {
        _stationID          = 0;
        x                   = 0;
        y                   = 0;
        tracksNumber        = 0;
        currentTrainNumber  = 0;
        maxStationCapacity  = 0.0F;
        avgPassengerExchangeTime = 2;
    }

    public Station(int _stationID, int x, int y, int tracksNumber, int avgPassengerExchangeTime) {
        this._stationID = _stationID;
        this.x = x;
        this.y = y;
        this.tracksNumber = tracksNumber;

        currentTrainNumber = 0; // < maxStationCapacity - 1
        this.avgPassengerExchangeTime = avgPassengerExchangeTime;

        maxStationCapacity = Math.floor(60 / (tracksNumber * avgPassengerExchangeTime));
    }

    Coordinates getPosition() {
        return new Coordinates(x, y);
    }

}
