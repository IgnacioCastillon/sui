import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class hola extends JFrame {
    private JButton boton;
    private JLabel texto;
    private JPanel panel1;
    private JLabel pesada;
    private JTextField nombre1;
    private JTextField nombre2;
    private JLabel nombre;
    private JButton boton2;
    private int num;
    Random rd = new Random();
    boolean oculto = false;
    private int intentos = 0;


    public hola() {
        boton2.setVisible(false);
    setTitle("Calculadora de amor");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(350,250);
    setContentPane(panel1);
    boton.addActionListener(e -> {
        acciones(e);
    });
        boton2.addActionListener(e ->  {
            acciones(e);
        });
    }
private void acciones(ActionEvent e) {
    if (e.getSource()==boton&&!oculto) {
        calcular(nombre1.getText(), nombre2.getText());
        ocultar();
    } else if (e.getSource()==boton2&&intentos<3) {
        intentos++;
        calcular(nombre1.getText(), nombre2.getText());
    } else if (e.getSource()==boton&&oculto) {
        mostrar();
    } else if (e.getSource()==boton2&&intentos>=3) {
        intentos++;
        texto.setText("No te quiere admitelo ya");
    }

}
private void calcular(String nombre11, String nombre22) {
        reiniciar();
    num = rd.nextInt(100+1);
    texto.setText(nombre11+" y "+nombre22+" tienen un "+num+"% de compatibilidad.");
}
    private void calcular2(String nombre11, String nombre22) {
        reiniciar();
        num = 100;
        texto.setText(nombre11+" y "+nombre22+" tienen un "+num+"% de compatibilidad.");
    }
private void reiniciar(){
        texto.setText("");
        num = 0;
}
private void ocultar(){
        oculto = true;
    nombre1.setVisible(false);
    nombre2.setVisible(false);
    nombre.setVisible(false);
    pesada.setVisible(false);
    boton.setText("Cambiar nombres");
    boton2.setVisible(true);
    boton2.setText("Mentira");
    texto.setVisible(true);
    boton2.setVisible(true);
}


private void mostrar(){
    oculto = false;
    boton.setText("Pulsa aqui");
    nombre1.setVisible(true);
    nombre2.setVisible(true);
    nombre.setVisible(true);
    pesada.setVisible(true);
    boton.setVisible(true);
    texto.setVisible(false);
    boton2.setVisible(false);
}

}