package org.objects.Delay;

import org.objects.BaseDelay;

public class TrainFailureDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private int SPT;
    private boolean stopsTrain;
    public String nameID;

    // default constructor
    public TrainFailureDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        SPT             = 0;
        stopsTrain      = false;
        nameID            = "none";
    }

    // constructor
    public TrainFailureDelay(float minProbability, float maxProbability, int SPT, boolean stopsTrain, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this.SPT            = SPT;
        this.stopsTrain     = stopsTrain;
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
