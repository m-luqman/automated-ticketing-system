public class ParkingLotAdapter {
    private ParkingLot parkingLot;
    private final String noParkingLotMessage = "Parking lot not created";

    public String createParking(String createParkingCommand) {
        Integer noOfSlots = Integer.parseInt(createParkingCommand.split(" ")[1]);
        parkingLot = new ParkingLot(noOfSlots);
        return "Created a parking lot with "
                    .concat(noOfSlots.toString())
                    .concat(" slots");
    }

    public String park(String parkCommand) {
        if(parkingLot == null) return noParkingLotMessage;
        String[] commandArgs = parkCommand.split(" ");
        return parkingLot.park(new Car(commandArgs[1], commandArgs[2]));
    }

    public String leave(String leaveCommand) {
        if(parkingLot == null) return noParkingLotMessage;
        Integer slotNumber = Integer.parseInt(leaveCommand.split(" ")[1]);
        return parkingLot.leave(slotNumber);
    }

    public String getStatus(String statusCommand) {
        if(parkingLot == null) return noParkingLotMessage;
        return parkingLot.getStatus();
    }

    public String getRegistrationNumbersByColor(String registrationNumberByColorCommand) {
        if(parkingLot == null) return noParkingLotMessage;
        String color = registrationNumberByColorCommand.split(" ")[1];
        return parkingLot.getRegistrationNumbersByColor(color);
    }

    public String getSlotNumbersByColor(String slotNumberByColorCommand) {
        if(parkingLot == null) return noParkingLotMessage;
        String color = slotNumberByColorCommand.split(" ")[1];
        return parkingLot.getSlotNumbersByColor(color);
    }

    public String getSlotNumbersByRegistrationNumber(String slotNumberByRegistrationNumberCommand) {
        if(parkingLot == null) return noParkingLotMessage;
        String registrationNumber = slotNumberByRegistrationNumberCommand.split(" ")[1];
        return parkingLot.getSlotNumberByRegistrationNumber(registrationNumber);
    }
}
