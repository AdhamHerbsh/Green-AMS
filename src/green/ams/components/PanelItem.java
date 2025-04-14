package green.ams.components;

import javax.swing.JPanel;

public class PanelItem extends JPanel {

    public PanelItem() {
        setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
    }
}
