package org.objects.Train;

public class PassengerTrain extends Train {
    public float relativeAttendance;

    public PassengerTrain(int _NID, int VMax, int avgPassengerCount, int maxPassengerCount) {
        super(_NID, VMax);

        relativeAttendance = ((float) avgPassengerCount / maxPassengerCount) * 100; // %
    }
}
