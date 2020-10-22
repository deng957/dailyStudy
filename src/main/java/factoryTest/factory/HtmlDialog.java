package factoryTest.factory;

import factoryTest.buttons.Button;
import factoryTest.buttons.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    public Button createButton() {
        return new HtmlButton();
    }
}
