package org.dds.objects.DelayTypes;

import org.dds.objects.Delay;

public class ZWA extends Delay {

    public ZWA(float minProbability, float maxProbability, int _ID, String nameID, int[] calcStageUntil, double[] calcStageFormula) {
        super(minProbability, maxProbability, _ID, nameID, calcStageUntil, calcStageFormula);
    }

	@Override
	protected int calcSpecificCondition(int i, int n, int Tc) {
		if(i == 0){
			return (int)Math.ceil(Tc * 1/6);
		} else {
			return (int)super.calcStageFormula[n];
		}
	}
}
