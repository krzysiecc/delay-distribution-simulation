package org.dds.objects;

public class Route {
    public static int _routeID = 0;
    private boolean secondTrack;
    private int VMax;
    private Station start;
    private Station end;

    public Route() {
        secondTrack = false;
        VMax        = 100;
        start       = new Station();
        end         = new Station();
    }

    public Route(boolean secondTrack, int VMax, Station start, Station end) {
        this.secondTrack = secondTrack;
        this.VMax        = VMax;
        this.start       = start;
        this.end         = end;

        _routeID++;

        System.out.print("Utworzono szlak nr " + _routeID + " ");
        System.out.print(secondTrack ? "dwutorowy " : "jednotorowy ");
        System.out.print("o prędkości maksymalnej " + VMax + " km/h. ");
        // Również do poprawy
        System.out.print("TRASA: " + this.start.getStationName() + " - " + this.end.getStationName());
    }
    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public Boolean isSecondTrack() {
        return secondTrack;
    }
}
