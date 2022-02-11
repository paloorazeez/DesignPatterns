package dp.structural.decorator;

public class DecoratorDemo {


    public static void main(String[] args) {

        DosaDecorator dosaDecorator = new OnionDecorator(new CheeseDecorator(new PlainDosa()));
        dosaDecorator.prepare();
    }
}


interface Dosa{

    void prepare();
}

class PlainDosa implements Dosa{

    @Override
    public void prepare() {
        System.out.println("Preparing plain dosa...");
    }
}

abstract class DosaDecorator implements Dosa{

    private Dosa dosa;

    public DosaDecorator(Dosa dosa) {
        this.dosa = dosa;
    }

    @Override
    public void prepare() {
        this.dosa.prepare();
        decorate();
    }

    abstract void decorate();
}

class CheeseDecorator extends DosaDecorator{

    public CheeseDecorator(Dosa dosa) {
        super(dosa);
    }

    @Override
    void decorate() {
        System.out.println("Decorating with cheese");
    }
}

class OnionDecorator extends DosaDecorator{

    public OnionDecorator(Dosa dosa) {
        super(dosa);
    }

    @Override
    void decorate() {
        System.out.println("Decorating with onion");
    }
}