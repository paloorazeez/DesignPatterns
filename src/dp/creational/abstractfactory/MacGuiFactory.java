package dp.creational.abstractfactory;

public class MacGuiFactory extends GuiFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox creackCheckBox() {
        return new MacCheckBox();
    }
}
