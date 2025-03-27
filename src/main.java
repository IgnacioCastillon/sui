

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            hola control = new hola();
            control.setVisible(true);
        });
    }
}
