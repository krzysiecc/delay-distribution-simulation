package org.objects.Train;

import org.objects.BaseTrain;

import java.util.ArrayList;

public class Train implements BaseTrain {

    private int _NID;
    private int _lastStationID, _nextStationID, _railRouteID;
    private String _currentDelayNameID;
    private int currentDelay;
    public int currentV;
    private int VMax;

    private ArrayList<Integer> stationsLeft;
    private ArrayList<Integer> stationsPassed;

    public Train() {
        this._NID = 0;
        _lastStationID  = 0;
        _nextStationID  = 0;
        _railRouteID    = 0;

        _currentDelayNameID = "";
        currentDelay        = 0;

        currentV    = 0;
        this.VMax   = 160;

        stationsLeft    = null;
        stationsPassed  = null;
    }

    public Train(int _NID, int VMax) {
        this._NID       = _NID;
        _lastStationID  = 0;
        _nextStationID  = 0;
        _railRouteID    = 0;

        _currentDelayNameID = "";
        currentDelay        = 0;

        currentV    = 0;
        this.VMax   = VMax;
    }

    @Override
    public void moveViewOnMap() {

    }

    @Override
    public void showDetails() {

    }

    @Override
    public void backtrackSameDirection() {

    }

    @Override
    public void calculateThroughput() {

    }
}
