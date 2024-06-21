package org.dds.objects;

import org.dds.objects.BaseTrain;
import org.dds.objects.Station;
import org.dds.objects.Track;

import java.util.*;
import java.lang.Math;

import org.dds.framework.FileManager;

public class Train implements BaseTrain {

    private static int countTrains = 0;

	private boolean reversor;
    private int _NID;
	private String logPath;
	private FileManager fm;

	// Complete delay is framesOfExistence minus anticipatedTravelTime
	private int framesOfExistence;
    private int anticipatedTravelTime;
    private int currentDelay;
    private int VMax;

    private Station _nextStation, _startStation;
    private LinkedList<Track> tracksLeft;
    private int trackIteration;
    private Track currentTrack;
	private boolean endOfRoute;
    private double x, y;

    // The angle of the train between it and the station as well
    // as calculation guide variables.
    private double angle, angleX, angleY;

	// The direction on which the train is heading
    // "lewo prawo" - left-right - lp
	// "góra dół"   - up-down    - gd
    private int lp, gd;

    /*
     * Direction code explanation:
     *
     * +-------------------------X    The upper leftmost corner is considered
     * |                              the origin, (0,0). With going down, and
     * |           -y                 right being considered + directions.
     * |                              So down+right is (1,1)
     * |      -x    O     +x          and up+left is (-1,-1)
     * |
     * |           +y                 „O” is the station, and depending
     * |                              on where the train is, no matter
     * |                              which route it is assigned to,
     * Y                              and no matter the angle it has,
     *                                a direction on which it travels will
     *                                be always known at easy to check.
     */

    public Train() {
        tracksLeft = new LinkedList<>();
        fm = new FileManager("default.txt");

        _NID = countTrains++;

        x 		= 0;
        y 		= 0;
        angleX  = 0;
        angleY  = 0;
        lp 		= 0;
        gd 		= 0;

        framesOfExistence = -1;

		currentDelay = 0;
        this.VMax    = 100;

		endOfRoute = false;
    }

    public Train(int _NID, Station _startStation, LinkedList<Track> tracksLeft) {
        this._NID = _NID;

        /*
         * Because we start counting frames before the train even ends up
         * moving, it always ends up being a frame late, so we make it
         * think it started existing with -1 frames. As to not have to
         * add multiple instances of framesOfExistence++ across frameMove()
         */

        logPath = ("./TrainLogs/train_" + _NID + ".txt");
        fm = new FileManager(logPath);
        fm.createFile();

        framesOfExistence = -1;
		anticipatedTravelTime = calculateTime(_startStation, tracksLeft);

		this._startStation = _startStation;
		this.tracksLeft = tracksLeft;
		trackIteration = 0;

		if (this.tracksLeft.getFirst().getPoint1() == this._startStation || this.tracksLeft.getFirst().getPoint2() == this._startStation) {
			this.reversor = false;
			currentTrack = this.tracksLeft.getFirst();
		} else {
			this._NID++;
			this.reversor = true;
			currentTrack = this.tracksLeft.getLast();
		}

        _nextStation = whereTo(this._startStation, currentTrack);

		x = this._startStation.getX();
		y = this._startStation.getY();

        currentDelay = 0;
        this.VMax = currentTrack.getVMax();

		currentTrack.registerTrain(this);
        getAngles();
        getDirection();

        fm.writeToFile("START: " + this._startStation.getStationName() + ";" + _nextStation.getStationName() + ";" + currentTrack.getID() + ";" + VMax + ";" + anticipatedTravelTime + ";" + framesOfExistence + "\n");

		endOfRoute = false;
	}

    private Station whereTo(Station from, Track on) {

        /*
         * We check from where the train comes from, and we compare it
         * to the point connected to the track, and choose the one which
         * the train doesn't come from. This allows bidirectional use of
         * one path set.
        */

        if (from == on.getPoint1()) {
            return on.getPoint2();
        } else {
            return on.getPoint1();
        }
    }

    private boolean reachedDestination() {

		if (trackIteration + 1 < tracksLeft.size()) {
			trackIteration++;
			currentTrack.cleanTrain(this);
			if(reversor) {
				currentTrack = tracksLeft.get(tracksLeft.size() - 1 - trackIteration);
			} else {
				currentTrack = tracksLeft.get(trackIteration);
			}
			currentTrack.registerTrain(this);
			_startStation = _nextStation;
			_nextStation = whereTo(_startStation, currentTrack);
	        VMax = currentTrack.getVMax();

	        fm.writeToFile("NEW DIRECTION: " + _startStation.getStationName() + ";" + _nextStation.getStationName() + ";" + framesOfExistence +  ";" + VMax + "\n");
	    } else {
			currentTrack.cleanTrain(this);
	        fm.writeToFile("(!) END OF ROUTE: " + anticipatedTravelTime + ";" + framesOfExistence + ";" + (framesOfExistence - anticipatedTravelTime) + ";" + _nextStation.getStationName() +"\n");
			endOfRoute = true;
			// kill object
			return true;
		}

		getAngles();
		getDirection();

		// object's fine
		return false;
    }

    private void getAngles() {

        /*
         * Let's consider the origin being the train, and „o” the station.
         *             +Y
         *              ∧    o
         *          \   |   /|            We ALWAYS calculate the angle
         *           \  |  / |            between the path and the X
         *            \ | /  |            coordinate line.
         *           (α\|/α) |            In this case we are calculating
         * -------------+----+-------->+X α using the tangent.
         *           (α/|\α)
         *            / | \               tg(α) = Y/X    ->    α = atg(Y/X)
         *           /  |  \
         *          /   |   \             But because in reality the train
         *                                is NOT the origin, we have to
         *                                calculate the difference in distance.
         */

        double diffX = Math.abs(_nextStation.getX() - x);
        double diffY = Math.abs(_nextStation.getY() - y);

        angle = Math.atan(diffY/diffX);

        angleX = Math.cos(angle);
        angleY = Math.sin(angle);
    }

    private void getDirection() {

        if (x > _nextStation.getX()) {
			// LEFT
            lp = -1;
        } else if (x < _nextStation.getX()) {
			// RIGHT
            lp = 1;
        } else {
            lp = 0;
        }

        if (y > _nextStation.getY()) {
			// UP
            gd = -1;
        } else if (y < _nextStation.getY()) {
			// DOWN
            gd = 1;
        } else {
            gd = 0;
        }
    }

	private int calculateTime(Station start, LinkedList<Track> tracksLeft) {
		int time = 0;
		double x, y, dis;
		Station from = start;
		Station to;
		Track n;

		for (int i = 0; i < tracksLeft.size(); i++) {
			n = tracksLeft.get(i);
			to = whereTo(from, n);
			x = Math.abs(to.getX() - from.getX());
			y = Math.abs(to.getY() - from.getY());

			dis = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

			from = to;
			time += (int)Math.ceil(dis / n.getVMax()*6);
		}

		return time;
	}

	@Override
    public boolean moveFrame() {
		framesOfExistence++;

		// Train can't move if delay has been applied
		if (currentDelay > 0) {

			fm.writeToFile("DELAY: " + currentDelay + "\n");
			currentDelay--;

			return false;
		}

		// A single frame is 1 min, so we have to compensate the speed which is in km/h

        double ruch = (double) VMax / 60;
        double disX = (lp * angleX * ruch);
        double disY = (gd * angleY * ruch);

        if(Math.abs(x - _nextStation.getX()) < Math.abs(disX) || Math.abs(y - _nextStation.getY()) < Math.abs(disY)) {

            x = _nextStation.getX();
            y = _nextStation.getY();
            if (reachedDestination()) {
                return true;
            }

        } else {
            x += disX;
            y += disY;
        }

		fm.writeToFile("STEP: " + x + ";" + y + ";" + framesOfExistence + ";" + currentDelay + "\n");

		/*
		    W konsoli zawsze będzie wypisana pozycja pociągu który właśnie
			dojechał do stacji 2 razy w ciągu jednej klatki.
		    Nie jest to przypadek jednego ruchu na dwie klatki.

		    (krzysiu) nie rozumiem
		*/

        return false;
    }

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void registerDelay(int delay, String nameID, int i) {
		fm.writeToFile("DELAY IMPOSED: type " + nameID + " on " + i + " in queue ... SIZE: " + delay + "\n");
		currentDelay += delay;
	}

	@Override
	public int getDelay() {
		return currentDelay;
	}

	@Override
	public Track requestCurrentTrack() {
		return currentTrack;
	}

	@Override
	public int getAnticipatedTravelTime() {
		return anticipatedTravelTime;
	}

	@Override
	public int getTrainID() {
		return _NID;
	}

	public boolean isEndOfRoute() {
		return endOfRoute;
	}
}
