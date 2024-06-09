package org.dds.objects.Delay;

import org.dds.objects.BaseDelay;

public class LineFailureDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private int SPT;
    private int _ID;
    private String nameID;

    // default constructor
    public LineFailureDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        SPT             = 0;
        _ID             = 0;
        nameID          = "none";
    }

    // constructor
    public LineFailureDelay(float minProbability, float maxProbability, int SPT, int _ID, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this.SPT            = SPT;
        this._ID            = _ID;
        this.nameID         = nameID;
    }

    @Override
    public int calculateDelay(int totalRouteTime) {
        return 0;
    }

    @Override
    public void lookForOtherTrain(int codeA, int codeB) {

    }

    @Override
    public void getID() {

    }
    @Override
    public void getInformation() {

    }

}
