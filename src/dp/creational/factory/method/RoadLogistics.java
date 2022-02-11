package dp.creational.factory.method;

public class RoadLogistics extends Logistics {

    @Override
    protected Transport createTransport() {
        return new Truck();
    }
}
