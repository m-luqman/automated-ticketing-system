import java.util.Optional;

public class ParkingSlot {
    private final int slotNumber;
    private final Optional<Car> parkedCar;
    public ParkingSlot(int slotNumber) {
        this.slotNumber = slotNumber;
        this.parkedCar = Optional.empty();
    }
    public ParkingSlot(int slotNumber, Optional<Car> parkedCar) {
        this.slotNumber = slotNumber;
        this.parkedCar = parkedCar;
    }
    public Integer getSlotNumber() {
        return slotNumber;
    }
    public Optional<Car> getParkedCar() {
        return parkedCar;
    }
    public ParkingSlot withCar(Car carToPark) {
        return new ParkingSlot(this.slotNumber, Optional.of(carToPark));
    }
    public ParkingSlot withoutCar() {
        return new ParkingSlot(this.slotNumber);
    }
}
