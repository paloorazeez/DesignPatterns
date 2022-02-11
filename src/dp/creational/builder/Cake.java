package dp.creational.builder;

public class Cake {

    private int sugar;//tbl spoon

    private int egg;//nos

    private int milk;//cups

    private int floor;//grams

    private int chocolate;//peaces


    private Cake(int sugar, int egg, int milk, int floor, int chocolate) {
        this.sugar = sugar;
        this.egg = egg;
        this.milk = milk;
        this.floor = floor;
        this.chocolate = chocolate;
    }


    @Override
    public String toString() {
        return "Cake{" +
                "sugar=" + sugar +
                ", egg=" + egg +
                ", milk=" + milk +
                ", floor=" + floor +
                ", chocolate=" + chocolate +
                '}';
    }


    static class CakeBuilder{

        private int sugar;//tbl spoon

        private int egg;//nos

        private int milk;//cups

        private int floor;//grams

        private int chocolate;//cups

        public CakeBuilder addSugar(int tblSpoon)
        {
            this.sugar+=tblSpoon;
            return this;
        }

        public CakeBuilder addEgg(int nos)
        {
            this.egg+=nos;
            return this;
        }

        public CakeBuilder addMilk(int cups)
        {
            this.milk+=cups;
            return this;
        }

        public CakeBuilder addFloor(int cups)
        {
            this.floor+=cups;
            return this;
        }

        public CakeBuilder addChocolate(int peace)
        {
            this.chocolate+=peace;
            return this;
        }


        public Cake buid()
        {
            return new Cake(this.sugar, this.egg, this.milk, this.floor, this.chocolate);
        }

    }


}
