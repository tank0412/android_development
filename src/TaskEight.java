public class TaskEight {
    public void doJob() {
        AirBusA320 airBusA320 = new AirBusA320();
    AirBusA380 airBusA380 = new AirBusA380();
    airBusA320.getLengthOfRun();
    airBusA320.getSpeed();

    System.out.println();
    airBusA380.getLengthOfRun();
    airBusA380.getSpeed();
    airBusA380.getPassengersCount();
    }
}

class AirBusA320 {
    int speed;
    int lengthOfRun;

public AirBusA320() {
    this.lengthOfRun = 2090;
    this.speed = 840;
}

public AirBusA320(int length, int speed) {
    this.lengthOfRun = length;
    this.speed = speed;
    }

    public void getLengthOfRun() {
    System.out.println("Length of run is " + lengthOfRun);
    }

    public void getSpeed() {
    System.out.println("Speed is " + speed);
    }

}

class AirBusA380 extends AirBusA320 {
    int passengersCount;

    public AirBusA380() {
        super(2050, 900);
        this.passengersCount = 525;
    }

    public void getPassengersCount() {
        System.out.println("Passengers count is " + passengersCount);
    }
}
