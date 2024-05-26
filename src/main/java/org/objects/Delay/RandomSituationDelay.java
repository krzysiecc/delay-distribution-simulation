package org.objects.Delay;

import org.objects.BaseDelay;

public class RandomSituationDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private boolean stopsTrain;
    public String nameID;

    // default constructor
    public RandomSituationDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        stopsTrain      = false;
        nameID          = "none";
    }

    // constructor
    public RandomSituationDelay(float minProbability, float maxProbability, boolean stopsTrain, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
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
