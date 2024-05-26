package org.objects.Delay;

import org.objects.BaseDelay;

public class LineFailureDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private int SPT;
    public String nameID;

    // default constructor
    public LineFailureDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        SPT             = 0;
        nameID          = "none";
    }

    // constructor
    public LineFailureDelay(float minProbability, float maxProbability, int SPT, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this.SPT            = SPT;
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
