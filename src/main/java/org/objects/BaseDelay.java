package org.objects;

public interface BaseDelay {
    int calculateDelay(int totalRouteTime);
    void lookForOtherTrain(int codeA, int codeB);
}
