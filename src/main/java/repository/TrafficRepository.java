package repository;
import model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class TrafficRepository {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Fine> readFines(String filePath) throws IOException {
        return Arrays.asList(objectMapper.readValue(new File(filePath), Fine[].class));
    }

    public List<TrafficEvent> readEvents(String filePath) throws IOException {
        return Arrays.asList(objectMapper.readValue(new File(filePath), TrafficEvent[].class));
    }

    public List<Vehicle> readVehicles(String filePath) throws IOException {
        return Arrays.asList(objectMapper.readValue(new File(filePath), Vehicle[].class));
    }

}
