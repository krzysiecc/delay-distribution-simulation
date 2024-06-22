package org.dds.objects.DelayTypes;

import org.dds.objects.Delay;

public class ASRK extends Delay {

    public ASRK(float minProbability, float maxProbability, int _ID, String nameID, int[] calcStageUntil, double[] calcStageFormula) {
        super(minProbability, maxProbability, _ID, nameID, calcStageUntil, calcStageFormula);
    }

	@Override
	protected int calcSpecificCondition(int i, int n, int Tc) {
		if(i == 0){
			return 2;
		} else {
			return (int)super.calcStageFormula[n];
		}
	}
}
