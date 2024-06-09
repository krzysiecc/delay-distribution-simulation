package org.dds.objects.Delay;

import org.dds.objects.BaseDelay;

public class TrainFailureDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private int SPT;
    private boolean stopsTrain;
    private int _ID;
    private String nameID;

    // default constructor
    public TrainFailureDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        SPT             = 0;
        stopsTrain      = false;
        _ID             = 0;
        nameID          = "none";
    }

    // constructor
    public TrainFailureDelay(float minProbability, float maxProbability, int SPT, boolean stopsTrain, int _ID, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this.SPT            = SPT;
        this.stopsTrain     = stopsTrain;
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
