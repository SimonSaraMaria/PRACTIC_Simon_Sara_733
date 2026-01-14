package service;
import model.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.io.PrintWriter;
import java.util.Map;
import java.util.LinkedHashMap;

public class EreignisService {

    public int calculateRisikoScore(TrafficEvent e) {
        int severity = e.getSeverity();

        return switch (e.getType()) {
            case SPEEDING -> severity * 2;
            case RED_LIGHT -> severity * 3;
            case ACCIDENT -> severity * 5;
            case PRIORITY_PASS -> severity * 1;
        };
    }
}
