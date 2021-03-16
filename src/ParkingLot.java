import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ParkingLot {
    private List<ParkingSlot> parkingSlots;
    ParkingLot(Integer numberOfSlots) {
        this.parkingSlots = IntStream
            .rangeClosed(1, numberOfSlots)
            .mapToObj(ParkingSlot::new)
            .collect(Collectors.toList());
    }

    public String park(Car aCar) {
        
        Optional<ParkingSlot> slotToPark = parkingSlots
            .stream()
            .filter(slot -> slot.getParkedCar().isEmpty())
            .findFirst()
            .map(slot -> slot.withCar(aCar));
        
        if(slotToPark.isEmpty())
            return "Sorry, parking lot is full";

        parkingSlots.set(slotToPark.get().getSlotNumber() - 1, slotToPark.get());
        
        return "Allocated slot number: "
            .concat(slotToPark.get().getSlotNumber().toString());
    }

    public String leave(Integer slotNumber) {
        Optional<ParkingSlot> slotToLeave = parkingSlots
            .stream()
            .filter(slot -> slot.getSlotNumber() == slotNumber)
            .filter(slot -> slot.getParkedCar().isPresent())
            .findAny()
            .map(slot -> slot.withoutCar());

        if(slotToLeave.isEmpty())
            return "Given slot is not occupied";

        parkingSlots.set(slotToLeave.get().getSlotNumber() - 1, slotToLeave.get());
        
        return "Slot number "
            .concat(slotNumber.toString())
            .concat(" is free");
    }

    public String getStatus() {
        return "Slot No.\n"
            .concat(parkingSlots
                        .stream()
                        .filter(slot -> slot.getParkedCar().isPresent())
                        .map(slot -> slot.getSlotNumber().toString())
                        .collect(Collectors.joining("\n")))
            .concat("\nRegistration No\n")
            .concat(parkingSlots
                        .stream()
                        .filter(slot -> slot.getParkedCar().isPresent())
                        .map(slot -> slot.getParkedCar().get().getRegistrationNumber())
                        .collect(Collectors.joining("\n")))
            .concat("\nColor\n")
            .concat(parkingSlots
                        .stream()
                        .filter(slot -> slot.getParkedCar().isPresent())
                        .map(slot -> slot.getParkedCar().get().getColour())
                        .collect(Collectors.joining("\n")));
    }

    public String getRegistrationNumbersByColor(String color) {
        return parkingSlots 
                    .stream()
                    .filter(slot -> slot.getParkedCar().isPresent())
                    .filter(slot -> slot.getParkedCar().get().getColour().equalsIgnoreCase(color))
                    .map(slot -> slot.getParkedCar().get().getRegistrationNumber())
                    .collect(Collectors.joining(", "));
    }

    public String getSlotNumbersByColor(String color) {
        return parkingSlots
                    .stream()
                    .filter(slot -> slot.getParkedCar().isPresent())
                    .filter(slot -> slot.getParkedCar().get().getColour().equalsIgnoreCase(color))
                    .map(slot -> slot.getSlotNumber().toString())
                    .collect(Collectors.joining(", "));
    }

    public String getSlotNumberByRegistrationNumber(String registrationNumber) {
        return parkingSlots
                    .stream()
                    .filter(slot -> slot.getParkedCar().isPresent())
                    .filter(slot -> slot.getParkedCar().get().getRegistrationNumber().equalsIgnoreCase(registrationNumber))
                    .map(slot -> slot.getSlotNumber().toString())
                    .findAny()
                    .orElse("Not found");
    }
}
