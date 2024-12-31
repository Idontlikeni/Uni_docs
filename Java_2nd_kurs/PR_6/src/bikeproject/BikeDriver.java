package bikeproject;

public class BikeDriver {

    public static void main(String[] args) {

        BikeParts bike1 = new RoadBike();
        RoadBike bike2 = new RoadBike("drop", "tourer", "semi-grip", "comfort", 14, 25, 18);
        BikeParts bike3 = new MountainBike();
        BikeParts bike4 = new Bike();

        bike1.printDescription();
        bike2.printDescription();
        bike3.printDescription();
        bike4.printDescription();
        bike1.setPostHeight(20);
        bike1.printDescription();
    }//end method main

}//end class BikeDriver
