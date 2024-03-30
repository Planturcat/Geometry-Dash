package util;

public class Time {
    public static double timeStarted= System.nanoTime();

    public static Double getTime() {
        return (System.nanoTime()-timeStarted)*1E-9;
    }
}
