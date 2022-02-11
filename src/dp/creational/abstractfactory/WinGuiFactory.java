package dp.creational.abstractfactory;

public class WinGuiFactory extends GuiFactory {
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public Checkbox creackCheckBox() {
        return new WinCheckBox();
    }
}
