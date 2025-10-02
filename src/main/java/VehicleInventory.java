import java.util.Scanner;

public class VehicleInventory {
    static Vehicle[] myVehicles = new Vehicle[20];//make it a class variable to be able to access it from all methods
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        myVehicles[0] = new Vehicle(101121, "FordExplorer", "Red", "45000", 13500);
        myVehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", "60000", 11000);        //long vehicleId, String makeModel, String color, String odometerReading, float price
        myVehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", "50000", 9700);        //long vehicleId, String makeModel, String color, String odometerReading, float price
        myVehicles[3] = new Vehicle(101124, "Honda Civic", "White", "70000", 7500);        //long vehicleId, String makeModel, String color, String odometerReading, float price
        myVehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", "55000", 14500);        //long vehicleId, String makeModel, String color, String odometerReading, float price
        myVehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", "30000", 1600);        //long vehicleId, String makeModel, String color, String odometerReading, float price

        while (true) {
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.print("Enter your command: ");
            int command = scanner.nextInt();
            scanner.nextLine();//clear the buffer
            switch (command) {
                case 1:
                    listAllVehicles();
                    break;
                case 2:
                    findVehicleByMakeModel();
                    break;
                case 3:
                    findVehiclesByPrice();
                    break;
                case 4:
                    findVehicleByColor();
                    break;
                case 5:
                    addAVehicle();
                    break;
                case 6:
                    return;
            }

        }

    }

    /**
     * Add Vehicle to the list if there's an open spot to put the car.
     *
     */
    public static void addAVehicle() {
        System.out.println("Enter vehicle Id:");

        long vehicleId = Long.parseLong(scanner.nextLine());
        System.out.println("Enter makeModel:");
        String makeModel = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter odometerReading:");
        String odometerReading = scanner.nextLine();
        System.out.println("Enter Price:");
        float vehiclePrice = Float.parseFloat(scanner.nextLine());


        for (int i = 0; i < myVehicles.length; i++) {
            if (myVehicles[i] == null) {//If there's an open spot add car to the list.
                myVehicles[i] = new Vehicle(vehicleId, makeModel, color, odometerReading, vehiclePrice);
                break;//Exit after adding the vehicle to the list.
            }
        }

    }

    /**
     * This method is going to list all the vehicles available Within the range entered by the user.
     */
    public static void findVehiclesByPrice() {
        System.out.print("Please Enter Price Range: (ex. 10,000-20,000)\nMin Value: ");
        int minCarPrice = scanner.nextInt();
        System.out.print("Max Value: ");
        int maxCarPrice = scanner.nextInt();
        for (int i = 0; i < myVehicles.length; i++) {
            if (myVehicles[i] == null) {//if there's an empty object break out the room
                break;
            }
            if ((minCarPrice < myVehicles[i].getPrice()) && (myVehicles[i].getPrice() < maxCarPrice)) {
                System.out.println(myVehicles[i].getMakeModel());
            }
        }
    }

    public static void findVehicleByMakeModel() {
        System.out.println("What Make/Model do you want listed:");
        String userMake = scanner.nextLine();
        for (int i = 0; i < myVehicles.length; i++) {
            if (myVehicles[i] == null) {
                break;
            }
            if (userMake.equalsIgnoreCase(myVehicles[i].getMakeModel())) {
                System.out.printf("There's a %s \n", myVehicles[i].getMakeModel());
            }
        }
    }

    public static void findVehicleByColor() {
        System.out.println("What Color cars do you want listed:");
        String userColor = scanner.nextLine();
        for (int i = 0; i < myVehicles.length; i++) {
            if (myVehicles[i] == null) {
                break;
            }
            if (userColor.equalsIgnoreCase(myVehicles[i].getColor())) {
                System.out.printf("There's a %s in %s\n", myVehicles[i].getMakeModel(), userColor);
            }
        }
    }

    /**
     * This method is going to list all the vehicles availabe by their model Name.
     */
    public static void listAllVehicles() {
        for (int i = 1; i < myVehicles.length; i++) {
            if (myVehicles[i] != null) {//Print available vehicles not the empty spots in the list
                System.out.printf("%d.%s\n", i, myVehicles[i].getMakeModel());
            }
        }
    }
}
