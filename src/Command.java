import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Command {
    private final static ParkingLotAdapter parkingLot = new ParkingLotAdapter();
    private final static Map<String, Function<String, String>> commandMappings;
    
    static {
        commandMappings = new HashMap<>();
        commandMappings.put("create_parking_lot", parkingLot::createParking);
        commandMappings.put("park", parkingLot::park);
        commandMappings.put("leave", parkingLot::leave);
        commandMappings.put("status", parkingLot::getStatus);
        commandMappings.put("registration_numbers_for_cars_with_colour", parkingLot::getRegistrationNumbersByColor);
        commandMappings.put("slot_numbers_for_cars_with_colour", parkingLot::getSlotNumbersByColor);
        commandMappings.put("slot_number_for_registration_number", parkingLot::getSlotNumbersByRegistrationNumber);
    }

    public static String execute(String command) {
        return commandMappings
                    .getOrDefault(command.split(" ")[0], invalidCommand -> "Invalid command")
                    .apply(command);
    }
}
