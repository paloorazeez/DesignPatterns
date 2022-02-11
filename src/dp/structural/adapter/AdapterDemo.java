package dp.structural.adapter;

import java.util.Arrays;

public class AdapterDemo {

    public static void main(String[] args) {

        Movable bugattiVeyron = new BugattiVeyron();
        MovableAdapter bugattiVeyronAdapter = new MovableAdapterImpl(bugattiVeyron);
        System.out.println(bugattiVeyron.getSpeed()+" MPH converted to: "+bugattiVeyronAdapter.getSpeed()+ " KMPH");

    }
}

interface Movable{

    //return speed in mile per hour
    double getSpeed();
}

class BugattiVeyron implements Movable {

    @Override
    public double getSpeed() {
        return 268;
    }
}

interface MovableAdapter
{
    double getSpeed();
}

class MovableAdapterImpl implements MovableAdapter{

    private Movable movable;

    public MovableAdapterImpl(Movable movable) {
        this.movable = movable;
    }

    @Override
    public double getSpeed() {
        return convertMPHtoKMPH(movable.getSpeed());
    }

    private double convertMPHtoKMPH(double mph) {
        return mph * 1.60934;
    }
}