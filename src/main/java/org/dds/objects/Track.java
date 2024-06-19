package org.dds.objects;

import java.util.LinkedList;

public class Track {
    private static int countRoutes = 0;
    private int _ID;
    private boolean secondTrack;
    private int VMax;
    private Station point1;
    private Station point2;

    public LinkedList<Train> onTrack = new LinkedList<Train>();

    public Track(int VMax, Station point1, Station point2, boolean secondTrack) {
        _ID = countRoutes++;
        this.secondTrack = secondTrack;
        this.VMax        = VMax;
        this.point1      = point1;
        this.point2      = point2;

        System.out.print("Rail route no " + _ID + " ");
        System.out.print(secondTrack ? "double-track " : "single-track ");
        System.out.print("with VMax of " + VMax + " km/h. ");
        System.out.println("ROUTE: " + this.point1.getStationName() + " - " + this.point2.getStationName());

    }

    public void registerTrain(Train i) {
        onTrack.add(i);
        System.out.println("REGISTERED TRAIN: " + i.getTrainID() + " ON TRACK " + _ID);
    }

    public void cleanTrain(Train i) {
		onTrack.remove(i);
		System.out.println("REMOVED TRAIN: " + i.getTrainID() + " FROM TRACK " + _ID);
	}

	public Train returnTrain(int i) {
		return onTrack.get(i);
	}

    public Station getPoint1() {
        return point1;
    }

    public Station getPoint2() {
        return point2;
    }

    public int getVMax() {
        return VMax;
    }

    public boolean isSecondTrack() {
		return secondTrack;
	}

	public int getID() {
		return _ID;
	}
}
