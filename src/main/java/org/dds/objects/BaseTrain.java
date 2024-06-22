package org.dds.objects;

/**
 *  {@link BaseTrain} is an interface describing basic dependencies for every {@link Train} object.
 *  <p> Function moveFrame is called every frame and in general, it resolves frame-wise motion train around the map.
 *  If the function returns "true" value, it means that the train has reached its destination and must be removed. </p>
 *
 *  <p> With function registerDelay, there is an availability of contacting {@link Train} objects to impose a delay on them. </p>
 *
 *  <p> Function getDelay returns the size of a Train object' delay,
 *   Usually if it already has some delay imposed on it, it will not be added to it when it is drawn at any from the next frames. </p>
 *
 *  <p> WIth the function requestCurrentTrack "the Delay action" acts as the integrator and therefore, calls for the Train object
 *  that was drawn for its own track, and then imposes a delay on every train running after the first one on the same track.</p>
 *
 *  <p>Function getAnticipatedTravelTime returns value predicting, how long it will take to traverse to the
 *  end of the route (in frames) for a specific train.</p>
 */

public interface BaseTrain {

	boolean moveFrame();

	void registerDelay(int delay, String nameID, int i);

	int getDelay();

	Track requestCurrentTrack();

	int getAnticipatedTravelTime();

	int getTrainID();

	double getX();
	double getY();
}
