package org.dds.framework;

import org.dds.objects.DelayTypes.AL;
import org.dds.objects.DelayTypes.WCZ;
import org.dds.objects.DelayTypes.ZWA;
import org.dds.objects.Track;
import org.dds.objects.Station;
import org.dds.objects.Train;

import java.util.*;

public class Initialization {

    /*
        The delay-triggers are initialized once as finals - changes aren't possible.
        All types are pre-stated and described in the official documentation (!)
    */
    public final static WCZ WCZInitialize = new WCZ(0.01F, 0.05F, 501, "Wypadek z udzialem czlowieka", new int[] {4, 8}, new double[]{0.08333333333333333333, 0.04166666666666666667});
    public final static ZWA ZWAInitilize = new ZWA(0.2F, 0.3F, 512, "Zle warunki atmosferyczne", new int[]{3}, new double[]{1});
    public final static AL ALInitialize = new AL(0.05F, 0.1F, 401, "Awaria lokomotywy", new int[]{3, 6}, new double[]{0.14285714285714285714, 0.07142857142857142857});

    // public final static ASRK ASRKInitialize = new ASRK(0.3F, 0.35F, 402, "Awaria urządzeń sterowania ruchem kolejowym", new int[]{1, 3}, new double[]{1, 0});

    private static ArrayList<Station> stations;
    private static ArrayList<Track> tracks;
    private static ArrayList<Train> trains;

    public static void initializeObjects() {

        /*
            Each station is initialized separately and uniquely.
            Consequently, further extended to FrameAdvance function and added to station list (then sent as UI information).

            1000 x 500 px
        */

        stations = new ArrayList<>();

        Station WR = new Station("Wroclaw",500,250);               processStation(WR);
        Station KB = new Station("Kobierzyce",450,380);            processStation(KB);
        Station SB = new Station("Sobotka",250,420);               processStation(SB);
        Station SW = new Station("Swidnica",100,420);              processStation(SW);
        Station OB = new Station("Oborniki",490,180);              processStation(OB);
        Station ZG = new Station("Zmigrod",470,90);                processStation(ZG);
        Station RW = new Station("Rawicz",480,30);                 processStation(RW);
        Station KW = new Station("Katy Wroclawskie",300,300);      processStation(KW);
        Station JS = new Station("Jaworzyna Slaska",90,330);       processStation(JS);
        Station DS = new Station("Dzierzoniow Slaski",440,450);    processStation(DS);

        /*
            Tracks (Track objects) are not guarded by anything except trains themselves.
            They are used to construct routes which all assigned trains can run on.

            A track itself marks the connection between two stations and the parameters of it, eg.
            max speed, double-tracked trail etc.

            The Tracks are then arranged in a LinkedList to create a finite route for any type of trains,
        */

        tracks = new ArrayList<>();

        Track WR_KB = new Track(120, WR, KB, true); tracks.add(WR_KB);
        Track WR_OB = new Track(120, WR, OB, true); tracks.add(WR_OB);
        Track WR_KW = new Track(120, WR, KW, true); tracks.add(WR_KW);

        Track KB_SB = new Track(100, KB, SB, false); tracks.add(KB_SB);
        Track SB_SW = new Track(100, SB, SW, false); tracks.add(SB_SW);

        Track KW_JS = new Track(140, KW, JS, true); tracks.add(KW_JS);
        Track JS_SW = new Track(140, JS, SW, true); tracks.add(JS_SW);

        Track OB_ZG = new Track(160, OB, ZG, true); tracks.add(OB_ZG);
        Track ZG_RW = new Track(160, ZG, RW, true); tracks.add(ZG_RW);

        LinkedList<Track> WR_KW_JS = new LinkedList<>();
        WR_KW_JS.add(WR_KW);
        WR_KW_JS.add(KW_JS);
        WR_KW_JS.add(JS_SW);

        LinkedList<Track> WR_KB_SB_DS = new LinkedList<>();
        WR_KB_SB_DS.add(WR_KB);
        WR_KB_SB_DS.add(KB_SB);
        WR_KB_SB_DS.add(SB_SW);

        LinkedList<Track> WR_OB_ZG = new LinkedList<>();
        WR_OB_ZG.add(WR_OB);
        WR_OB_ZG.add(OB_ZG);
        WR_OB_ZG.add(ZG_RW);

        /*
            At the moment, all trains are being generated at the same time of the simulation (limitations of the FrameAdvance parent-function)
            The parameters needed to create a Train object are:
                a starting point,
                a route which they are going through.
            If the start-station isn't included in the given route, the train will cease to generate.
            Selecting a center station is not expected.
            You need to select one of the end stations.
        */

        trains = new ArrayList<>();

        Train IC1 = new Train(WR, WR_KW_JS); FrameAdvance.addPassenger(IC1);
        Train IC2 = new Train(DS, WR_KW_JS); FrameAdvance.addPassenger(IC2);
        Train IC3 = new Train(WR, WR_KB_SB_DS); FrameAdvance.addPassenger(IC3);
        Train IC4 = new Train(DS, WR_KB_SB_DS); FrameAdvance.addPassenger(IC4);
        Train IC5 = new Train(WR, WR_OB_ZG); FrameAdvance.addPassenger(IC5);
    }

    public static void processStation(Station station) {
        FrameAdvance.addStation(station);
        stations.add(station);
    }

    public static ArrayList<Station> getStations() {
        return stations;
    }

    public static ArrayList<Track> getTracks() {
        return tracks;
    }

    public static ArrayList<Train> getTrains() {
        return trains;
    }
}
