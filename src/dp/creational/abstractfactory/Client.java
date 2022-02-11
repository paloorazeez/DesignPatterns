package dp.creational.abstractfactory;

public class Client {

    public static void main(String[] args) {

        GuiFactory factory = new MacGuiFactory();
        Checkbox checkbox = factory.creackCheckBox();
        checkbox.check();

    }
}
