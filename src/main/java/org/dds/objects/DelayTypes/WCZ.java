package org.dds.objects.DelayTypes;

import org.dds.objects.Delay;

public class WCZ extends Delay {

    public WCZ(float minProbability, float maxProbability, int _ID, String nameID, int[] calcStageUntil, double[] calcStageFormula) {
        super(minProbability, maxProbability, _ID, nameID, calcStageUntil, calcStageFormula);
    }

	@Override
	protected int calcSpecificCondition(int i, int n, int Tc) {
		int workTc = Tc;
		if(!randomTrack.isSecondTrack()) {
			workTc *= 2;
		} if(i == 0){
			return workTc * 2;
		} else {
			return (int)Math.ceil(workTc * super.calcStageFormula[n]) * 2;
		}
	}
}


