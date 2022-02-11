package dp.behavioural.state;

public class StatePatternDemo {

    public static void main(String[] args) {
        Package pack = new Package();
        pack.printState();

        pack.nextState();
        pack.printState();

        pack.previousState();
        pack.printState();

        pack.nextState();
        pack.printState();

        pack.nextState();
        pack.printState();
    }
}

class Package{

    private PackageState state = new OrderedState();

    public void setState(PackageState state) {
        this.state = state;
    }


    public void nextState()
    {
        state.next(this);
    }


    public void previousState()
    {
        state.prev(this);
    }

    public void printState()
    {
        state.print(this);
    }
}
 interface PackageState {

    void next(Package pack);

    void prev(Package pack);

    void print(Package pack);
}

class OrderedState implements PackageState{

    @Override
    public void next(Package pack) {
        pack.setState(new DispatchedState());
    }

    @Override
    public void prev(Package pack) {

        System.out.println("This is the root state");
    }

    @Override
    public void print(Package pack) {
        System.out.println("Package is in Ordered state");
    }
}

class DispatchedState implements PackageState{

    @Override
    public void next(Package pack) {

        pack.setState(new RecievedState());
    }

    @Override
    public void prev(Package pack) {

        pack.setState(new OrderedState());
    }

    @Override
    public void print(Package pack) {

        System.out.println("Package is in Dispatched state");
    }
}

class RecievedState implements PackageState{

    @Override
    public void next(Package pack) {

        System.out.println("Package is already received ");
    }

    @Override
    public void prev(Package pack) {
        pack.setState(new DispatchedState());

    }

    @Override
    public void print(Package pack) {
        System.out.println("Package is in Received state ");

    }
}