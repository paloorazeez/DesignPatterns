package dp.creational.abstractfactory;

public class WinButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows button :: paint");
    }
}
