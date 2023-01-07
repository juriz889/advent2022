package day15;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SensorDistance {
    private static final Pattern INSTRUCTION = Pattern.compile("Sensor at x=(-?\\d+), y=(-?\\d+): closest beacon is at x=(-?\\d+), y=(-?\\d+)");

    public int calcPossibleBeacons(String input, int calcY) {
        String[] split = input.split("\n");
        int greatestX = 0;
        int smallestX = 0;
        List<Sensor> sensors = new ArrayList<>(
        );
        Set<Beacon> beacons = new HashSet<>();
        for (String s : split) {
            Matcher matcher = INSTRUCTION.matcher(s);
            if (matcher.find()) {
                int sensorX = Integer.parseInt(matcher.group(1));
                int sensorY = Integer.parseInt(matcher.group(2));
                int beaconX = Integer.parseInt(matcher.group(3));
                greatestX = Math.max(beaconX, Math.max(greatestX, sensorX));
                smallestX = Math.min(beaconX, Math.min(smallestX, sensorX));
                int beaconY = Integer.parseInt(matcher.group(4));
                Beacon beacon = new Beacon(beaconX, beaconY);
                Sensor sensor = new Sensor(sensorX, sensorY, beacon);
                beacons.add(beacon);
                sensors.add(sensor);
            } else {
                throw new IllegalStateException("Could not match");
            }
        }
        int count = 0;

        Set<Integer> seenXs = new HashSet<>();
        for (Sensor sensor : sensors) {
            if (sensor.getY() == calcY) seenXs.add(sensor.getX());
            if (sensor.getBeacon().getY() == calcY) seenXs.add(sensor.getBeacon().getX());

            for (int x = sensor.getX() - sensor.distanceToBeacon(); x <= sensor.getX() + sensor.distanceToBeacon(); x++) {
                if (!seenXs.contains(x) && Math.abs(sensor.getX() - x) + Math.abs(sensor.getY() - calcY) <= sensor.distanceToBeacon()) {
                    seenXs.add(x);
                    count++;
                }
            }
        }

        return count;
    }
}
