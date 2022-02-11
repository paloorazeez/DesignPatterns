package dp.structural.composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeDemo {

    public static void main(String[] args) {

        Box box = new Box(Arrays.asList(()->100.0,()->1000.90,
                new Box(Arrays.asList(()->20.00 , new LeafItem("Pen", 50.0)))
                ));
        System.out.println(box.getPrice());
    }
}

interface Item{

    double getPrice();



}

class Box implements Item{

    public Box() {
        this.itemList = new ArrayList<>();
    }



    private List<Item> itemList;

    private double price;

    public  Box(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public double getPrice() {
        itemList.forEach(item->{

                this.price+=item.getPrice();


        });
        return this.price;
    }


}

class LeafItem implements Item{

    private String name;
    private double price;

    public LeafItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return this.price;
    }


}

