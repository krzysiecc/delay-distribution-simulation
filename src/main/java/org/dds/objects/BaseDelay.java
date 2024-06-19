package org.dds.objects;

/**
 * Every frame, an activated "lottery" or delay will be triggered, according to previously initialized probabilistic values.
 * After that, it selects a random train and checks whether it already has a delay, if not, we impose a delay on it.
 * If it doesn't find the train without delay after 500 tries, function gives up and ends with an empty return.
 */

public interface BaseDelay {

	void moveFrame();

	String getNameID();
}
