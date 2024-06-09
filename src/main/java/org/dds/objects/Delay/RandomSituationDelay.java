package org.dds.objects.Delay;

import org.dds.objects.BaseDelay;

public class RandomSituationDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private boolean stopsTrain;
    private int _ID;
    private String nameID;

    // default constructor
    public RandomSituationDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        stopsTrain      = false;
        _ID             = 0;
        nameID          = "none";
    }

    // constructor
    public RandomSituationDelay(float minProbability, float maxProbability, boolean stopsTrain, int _ID, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
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
