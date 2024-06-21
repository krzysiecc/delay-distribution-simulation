package org.dds.framework;

import org.dds.objects.DelayTypes.AL;
import org.dds.objects.DelayTypes.WCZ;
import org.dds.objects.DelayTypes.ZWA;
import org.dds.objects.Track;
import org.dds.objects.Station;
import org.dds.objects.Train;

import java.util.*;

import static org.dds.framework.Clock.ANIMATION_FRAME;

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

        Station WRO = new Station("Wroclaw",500,250);               processStation(WRO);
        Station KWR = new Station("Katy Wroclawskie",400,280);      processStation(KWR);
        Station JSL = new Station("Jaworzyna Slaska",270,300);      processStation(JSL);
        Station SWI = new Station("Swiebodzice",200,380);           processStation(SWI);
        Station WALB = new Station("Walbrzych",180,450);            processStation(WALB);

        Station KOB = new Station("Kobierzyce",460,330);            processStation(KOB);
        Station SOB = new Station("Sobotka",370,340);               processStation(SOB);
        Station SWD = new Station("Swidnica",310,390);              processStation(SWD);
        Station DSL = new Station("Dzierzoniow Slaski",330,450);    processStation(DSL);

        Station SRS = new Station("Sroda Slaska",360,220);          processStation(SRS);
        Station MAL = new Station("Malczyce",270,180);              processStation(MAL);
        Station LEG = new Station("Legnica",100,180);               processStation(LEG);

        Station OBR = new Station("Oborniki",490,200);              processStation(OBR);
        Station ZMI = new Station("Zmigrod",470,100);               processStation(ZMI);
        Station RAW = new Station("Rawicz",460,30);                 processStation(RAW);

        Station OLW = new Station("Olawa",590,340);                 processStation(OLW);
        Station BRZ = new Station("Brzeg",700,400);                 processStation(BRZ);
        Station OPL = new Station("Opole",900,450);                 processStation(OPL);

        /*
            Tracks (Track objects) are not guarded by anything except trains themselves.
            They are used to construct routes which all assigned trains can run on.

            A track itself marks the connection between two stations and the parameters of it, eg.
            max speed, double-tracked trail etc.

            The Tracks are then arranged in a LinkedList to create a finite route for any type of trains,
        */

        tracks = new ArrayList<>();

        Track WRO_KWR = new Track(160, WRO, KWR, true); tracks.add(WRO_KWR);
        Track KWR_JSL = new Track(160, KWR, JSL, true); tracks.add(KWR_JSL);
        Track JSL_SWI = new Track(160, JSL, SWI, true); tracks.add(JSL_SWI);
        Track SWI_WALB = new Track(160, SWI, WALB, true); tracks.add(SWI_WALB);

        // WROCŁAW - WAŁBRZYCH p/KĄTY WROCŁAWSKIE
        LinkedList<Track> WRO_WALB = new LinkedList<>();
        WRO_WALB.add(WRO_KWR);
        WRO_WALB.add(KWR_JSL);
        WRO_WALB.add(JSL_SWI);
        WRO_WALB.add(SWI_WALB);

        // -----------------------------------------------------------------------------------
        Track WRO_KOB = new Track(120, WRO, KOB, false); tracks.add(WRO_KOB);
        Track KOB_SOB = new Track(100, KOB, SOB, false); tracks.add(KOB_SOB);
        Track SOB_SWD = new Track(100, SOB, SWD, false); tracks.add(SOB_SWD);
        Track SWD_DSL = new Track(80, SWD, DSL, false); tracks.add(SWD_DSL);

        Track SWD_JSL = new Track(80, SWD, JSL, false); tracks.add(SWD_JSL);

        // WROCŁAW - DZIERŻONIÓW ŚL. p/ŚWIDNICA
        LinkedList<Track> WRO_DSL = new LinkedList<>();
        WRO_DSL.add(WRO_KOB);
        WRO_DSL.add(KOB_SOB);
        WRO_DSL.add(SOB_SWD);
        WRO_DSL.add(SWD_DSL);

        // DZIERŻONIÓW ŚL. - JAWORZYNA ŚL. p/ŚWIDNICA
        LinkedList<Track> DSL_JSL= new LinkedList<>();
        DSL_JSL.add(SWD_DSL);
        DSL_JSL.add(SWD_JSL);

        // -----------------------------------------------------------------------------------
        Track WRO_SRS = new Track(160, WRO, SRS, true); tracks.add(WRO_SRS);
        Track SRS_MAL = new Track(160, SRS, MAL, true); tracks.add(SRS_MAL);
        Track MAL_LEG = new Track(160, MAL, LEG, true); tracks.add(MAL_LEG);

        // WROCŁAW - LEGNICA - WROCŁAW p/MALCZYCE
        LinkedList<Track> WRO_LEG = new LinkedList<>();
        WRO_LEG.add(WRO_SRS);
        WRO_LEG.add(SRS_MAL);
        WRO_LEG.add(MAL_LEG);

        // -----------------------------------------------------------------------------------
        Track WRO_OBR = new Track(160, WRO, OBR, true); tracks.add(WRO_OBR);
        Track OBR_ZMI = new Track(160, OBR, ZMI, true); tracks.add(OBR_ZMI);
        Track ZMI_RAW = new Track(160, ZMI, RAW, true); tracks.add(ZMI_RAW);

        // WROCŁAW - LEGNICA p/ŻMIGRÓD
        LinkedList<Track> WRO_RAW = new LinkedList<>();
        WRO_RAW.add(WRO_OBR);
        WRO_RAW.add(OBR_ZMI);
        WRO_RAW.add(ZMI_RAW);

        // -----------------------------------------------------------------------------------
        Track WRO_OLW = new Track(160, WRO, OLW, true); tracks.add(WRO_OLW);
        Track OLW_BRZ = new Track(160, OLW, BRZ, true); tracks.add(OLW_BRZ);
        Track BRZ_OPL = new Track(160, BRZ, OPL, true); tracks.add(BRZ_OPL);

        // WROCŁAW - OPOLE p/OŁAWA, BRZEG
        LinkedList<Track> WRO_OPL = new LinkedList<>();
        WRO_OPL.add(WRO_OLW);
        WRO_OPL.add(OLW_BRZ);
        WRO_OPL.add(BRZ_OPL);

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

        Train KD66102 = new Train(66102, WRO, WRO_WALB, 1, 1); processTrains(KD66102);
        Train KD66104 = new Train(66104, WALB, WRO_WALB, 1, 1); processTrains(KD66104);

        Train KD66812 = new Train(66812, WRO, WRO_DSL, 21, 1); processTrains(KD66812);
        Train KD66814 = new Train(66814, DSL, WRO_DSL, 27, 1); processTrains(KD66814);

        Train KD66298 = new Train(66298, DSL, DSL_JSL, 39, 1); processTrains(KD66298);
        Train KD66296 = new Train(66296, JSL, DSL_JSL, 59, 1); processTrains(KD66296);

        Train KD66342 = new Train(66342, WRO, WRO_LEG, 61, 1); processTrains(KD66342);
        Train KD66348 = new Train(66348, LEG, WRO_LEG, 34, 1); processTrains(KD66348);

        Train KD66122 = new Train(66122, WRO, WRO_RAW, 33, 1); processTrains(KD66122);
        Train KD66124 = new Train(66124, RAW, WRO_RAW, 43, 1); processTrains(KD66124);

        Train R67098 = new Train(67098, WRO, WRO_OPL, 53, 1); processTrains(R67098);
        Train R67102 = new Train(67102, OPL, WRO_OPL, 53, 1); processTrains(R67102);
    }

    public static void processStation(Station station) {
        FrameAdvance.addStation(station);
        stations.add(station);
    }

    public static void processTrains(Train train) {
        trains.add(train);
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
