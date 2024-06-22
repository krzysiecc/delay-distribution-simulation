package org.dds.objects;

import org.dds.framework.FrameAdvance;

import static org.dds.framework.Initialization.independentEventsRate;

public class Delay implements BaseDelay {

	protected int[] calcStageUntil;
	protected double[] calcStageFormula;

    private final float minProbability;
    private final float maxProbability;
    private final int _ID;
    private int abort;
    private final String nameID;
    protected Train randomTrain;
    protected Track randomTrack;

    public Delay() {
        minProbability  = 0.0F;
        maxProbability  = 0.0F;
        _ID             = 0;
        nameID          = "none";
    }

    public Delay(float minProbability, float maxProbability, int _ID, String nameID, int[] calcStageUntil, double[] calcStageFormula) {
        this.minProbability = minProbability;
        this.maxProbability = maxProbability;
        this._ID            = _ID;
        this.nameID         = nameID;

        this.calcStageFormula = calcStageFormula;
        this.calcStageUntil   = calcStageUntil;
    }

	@Override
	public void moveFrame() {

		if(Math.random() < minProbability / independentEventsRate) {
			abort = 0;
			System.out.println("Delay imposed: " + nameID);
			randomTrain = findTrain();

			if (abort == 500) return;
			randomTrack = randomTrain.requestCurrentTrack();

			if (!randomTrack.onTrack.contains(randomTrain)) {
				return;
			}
			calculateAndApplyDelay();
		}
	}

	// Possible endless loop when all trains are already delayed.
	// End after 500 tries.
	private Train findTrain() {
		Train foundTrain = FrameAdvance.getRandomTrain();

		for (; foundTrain.getDelay() > 0 && abort < 500; abort++) {
			foundTrain = FrameAdvance.getRandomTrain();
		}

		return foundTrain;
	}

	protected int calcSpecificCondition(int i, int n, int Tc) {
		return 0;
	}

	private void calculateAndApplyDelay() {
		int n = 0;
		int trainListSize = randomTrack.onTrack.size();
		int trainListIndex = randomTrack.onTrack.indexOf(randomTrain);

//		System.out.print("Mamy pociąg: " + randomTrain.getID() + ", ");
//		System.out.print("Na trasie: " + randomTrack.getID() + ", ");
//		System.out.print("Z indeksem: " + trainListIndex + ", ");
//		System.out.println("w liście rozmiaru: " + trainListSize);

		for (int i=0; i <= trainListSize - trainListIndex - 1 && i <= calcStageUntil[calcStageUntil.length - 1] - 1 ; i++) {

			Train nextTrain = randomTrack.onTrack.get(i+trainListIndex);
			int Tc = nextTrain.getAnticipatedTravelTime();

			if(i > calcStageUntil[n]) {
				n++;
			}

			int delay = calcSpecificCondition(i, n, Tc);
			nextTrain.registerDelay(delay, getNameID(), i);
		}
	}

	@Override
	public String getNameID() {
		return nameID;
	}

}
