package org.dds.framework;

import org.dds.objects.Station;
import org.dds.objects.Train;

import java.util.ArrayList;
import java.util.LinkedList;

public class FrameAdvance {

    // Tracking lists
    private static ArrayList<Train> Passenger = new ArrayList<Train>();
    private static LinkedList<Station> Stations = new LinkedList<Station>();

    // Cleaning queues to remove unused objects from tracking lists
    private static ArrayList<Train> PTRemoveQueue = new ArrayList<Train>();

	public static int getTrainAmmount() {
		return Passenger.size();
	}

    public static void addPassenger(Train i) {
        Passenger.add(i);
    }

    public static Train getRandomTrain() {
		return Passenger.get((int)(Math.random() * Passenger.size()));
	}

    public static LinkedList<Station> getStation() {
        return Stations;
    }

    public static void addStation(Station i) {
        Stations.add(i);
    }

    public static void adv() {
        if(Passenger.isEmpty()) {
            return;
        }

        Passenger.forEach( (n) -> {

            /*
             * If n-train reaches it's final destination,
             * so if n.moveFrame returns „true” in the
             * next check, queue it for deletion from tracking Arraylist.
             */

            if(n.moveFrame()) {
                PTRemoveQueue.add(n);
            }
        } );

        // Remove all objects set for deletion.
        PTRemoveQueue.forEach( (n) -> {
            Passenger.remove(n);
        } );
        PTRemoveQueue.clear();

		if(!Passenger.isEmpty()){
			Initialization.WCZInitialize.moveFrame();
			Initialization.ZWAInitilize.moveFrame();
			Initialization.ALInitialize.moveFrame();
		}
    }
}
