package CasoPractico10;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            listaContactos lista = new listaContactos();
            lista.setVisible(true);
});
    }
}
