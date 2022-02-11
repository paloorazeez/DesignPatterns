package dp.creational.factory.method;

public class Client {

    public static void main(String[] args) {

        Logistics logistics = new RoadLogistics();
        logistics.planDelivery();
    }
}
