package org.dds.objects.Train;

import org.dds.objects.Station;

public class PassengerTrain extends Train {
    public float relativeAttendance;

    public PassengerTrain(int _NID, int VMax, Station startStation, Station endStation, int avgPassengerCount, int maxPassengerCount) {
        super(_NID, VMax, startStation, endStation);

        relativeAttendance = ((float) avgPassengerCount / maxPassengerCount) * 100; // %
    }
}
