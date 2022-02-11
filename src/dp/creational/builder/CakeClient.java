package dp.creational.builder;

public class CakeClient {

    public static void main(String[] args) {

        Cake.CakeBuilder builder = new Cake.CakeBuilder();
        Cake cake = builder.addChocolate(1).addEgg(2).addFloor(3).addMilk(5).addSugar(2).addEgg(1).buid();
        System.out.println(cake);

    }
}
