package org.dds.objects.DelayTypes.obsolete;

import org.dds.objects.BaseDelay;

public class TrainFailureDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private int _ID;
    private String nameID;

    public TrainFailureDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        _ID             = 0;
        nameID          = "none";
    }

    // constructor
    public TrainFailureDelay(float minProbability, float maxProbability, int _ID, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this._ID            = _ID;
        this.nameID         = nameID;
    }

    @Override
    public void moveFrame() {

    }

    @Override
    public String getNameID() {
        return null;
    }
}
