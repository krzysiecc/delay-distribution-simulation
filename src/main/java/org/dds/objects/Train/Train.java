package org.dds.objects.Train;

import org.dds.objects.BaseTrain;
import org.dds.objects.Station;

import java.util.ArrayList;

public class Train implements BaseTrain {

    private int _NID;
    private Station startStation, endStation;
    private String _currentDelayNameID;
    private int currentDelay;
    public int currentV;
    private int VMax;

    private ArrayList<Integer> stationsLeft;
    private ArrayList<Integer> stationsPassed;

    public Train() {
        this._NID       = 0;
        startStation    = null;
        endStation      = null;

        _currentDelayNameID = "";
        currentDelay        = 0;

        currentV    = 0;
        this.VMax   = 160;

        stationsLeft    = null;
        stationsPassed  = null;
    }

    public Train(int _NID, int VMax, Station startStation, Station endStation) {
        this._NID         = _NID;
        this.startStation = startStation;
        this.endStation   = endStation;

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

    public Station getStartStation() {
        return startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public int get_NID() {
        return _NID;
    }
}
