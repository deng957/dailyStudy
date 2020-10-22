package factoryTest.factory;

import factoryTest.buttons.Button;
import factoryTest.buttons.WindowsButton;

public class WindowsDialog extends Dialog {

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}