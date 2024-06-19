package org.dds.objects.DelayTypes;

import org.dds.objects.Delay;

public class AL extends Delay {

    public AL(float minProbability, float maxProbability, int _ID, String nameID, int[] calcStageUntil, double[] calcStageFormula) {
        super(minProbability, maxProbability, _ID, nameID, calcStageUntil, calcStageFormula);
    }

	@Override
	protected int calcSpecificCondition(int i, int n, int Tc) {
		if(i == 0){
			return (int)Math.ceil(Tc * 0.5);
		} else {
			return (int)Math.ceil(Tc * 0.5 * super.calcStageFormula[n]);
		}
	}
}
