package org.dds.objects.DelayTypes.obsolete;

import org.dds.framework.FrameAdvance;
import org.dds.objects.BaseDelay;
import org.dds.objects.Track;
import org.dds.objects.Train;


import java.lang.Math;

public class RandomSituationDelay implements BaseDelay {

    private float minProbability, maxProbability;
    private int _ID;
    private String nameID;
    private int abortCount = 0;
    Train randomTrain;
    Track randomTrack;
    public RandomSituationDelay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        //stopsTrain      = false;
        _ID             = 0;
        nameID          = "none";
    }

    public RandomSituationDelay(float minProbability, float maxProbability, int _ID, String nameID) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this._ID            = _ID;
        this.nameID         = nameID;
    }

	public void moveFrame() {

		if (Math.random() < minProbability) {
			abortCount = 0;
			randomTrain = findTrain();
			if(abortCount == 500) return;
			randomTrack = randomTrain.requestCurrentTrack();
			// calculateDelay();
		}
	}

    @Override
    public String getNameID() {
        return null;
    }

    public Train findTrain() {
		Train foundTrain = FrameAdvance.getRandomTrain();
		for(; foundTrain.getDelay() > 0 && abortCount < 500; abortCount++ ) {
			foundTrain = FrameAdvance.getRandomTrain();
		}
		return foundTrain;
	}
}
