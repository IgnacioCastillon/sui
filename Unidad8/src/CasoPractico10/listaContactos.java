package CasoPractico10;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class listaContactos extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField email;
    private JComboBox categoria;
    private JTextArea area;
    private JButton nuevo;
    private JButton guardar;
    private JButton cargar;
    private JPanel panel1;
    private JLabel Nombre;
    private String ruta = "contactos.csv";
    private File archivo = new File(ruta);
    private Contacto[] contactos = new Contacto[30];
    private boolean encontrado = false;
    private int contador = 0;
    private int agregados = 0;


    public listaContactos() {
        setTitle("Lista Contactos");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel1);
        setSize(400, 300);
        rellenarArray();
        cargar.addActionListener(e -> {
            acciones(e);
        });
        nuevo.addActionListener(e -> {
            acciones(e);
        });
        guardar.addActionListener(e -> {
            acciones(e);
        });
    }

    private void acciones(ActionEvent e) {
        if (e.getSource() == cargar) {
        cargarContactos();
        }
        if (e.getSource() == nuevo) {
        nuevoContacto();
        }
        if (e.getSource() == guardar) {
        guardarContactos();
        }
    }

    private void rellenarArray() {
        if (archivo.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                for (String linea = reader.readLine(); linea != null; linea = reader.readLine()) {
                    if (!linea.trim().isEmpty()) {
                        String[] partes = linea.split(",");
                        if (partes.length == 4) {
                            String[] nombre1 = partes[0].split(":");
                            String[] telefono1 = partes[1].split(":");
                            String[] email1 = partes[2].split(":");
                            String[] categoria1 = partes[3].split(":");

                            Contacto contacto = new Contacto(nombre1[1], telefono1[1], email1[1], categoria1[1]);
                            contactos[contador] = contacto;
                            contador++;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void nuevoContacto() {
            if (nombre.getText().isEmpty() || telefono.getText().isEmpty() || email.getText().isEmpty() || categoria.getSelectedItem().toString().isEmpty()) {
                JOptionPane.showMessageDialog(panel1, "Debe ingresar los campos");
            } else {
                if (agregados == 0) {
                    area.setText("Nombre: " + nombre.getText() + "\nTelefono: " + telefono.getText() + "\nE-mail: " + email.getText() + "\nCategoria: " + categoria.getSelectedItem().toString());
                    agregados++;
                } else {
                    area.setText(area.getText() + "\n\nNombre: " + nombre.getText() + "\nTelefono: " + telefono.getText() + "\nE-mail: " + email.getText() + "\nCategoria: " + categoria.getSelectedItem().toString());
                    agregados++;
                }
            }
    }

    private void guardarContactos() {
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                JOptionPane.showMessageDialog(panel1,"Archivo creado");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        String[] lineas = area.getText().split("\n\n");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            for (int i = 0; i < agregados; i++) {
                    writer.write(lineas[i] + "\n\n");

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

        private void cargarContactos(){
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Selecciona un archivo .csv");
        int resultado = j.showOpenDialog(panel1);

        if (resultado==JFileChooser.APPROVE_OPTION){
            File archivo = j.getSelectedFile();
            try(BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
                String linea;
                contador = 0;
                int contador2 = 0;
                while ((linea=reader.readLine())!=null){
                    if (!linea.isEmpty()){
                        String[] nombre = linea.split(":");
                        String[] telefono = reader.readLine().split(":");
                        String[] email = reader.readLine().split(":");
                        String[] categoria = reader.readLine().split(":");
                        Contacto contacto = new Contacto(nombre[1],telefono[1],email[1],categoria[1]);
                            contactos[contador] = contacto;
                            contador++;

                    }
                }
                mostrarContactos();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        }
        private void mostrarContactos(){
        agregados = 0;
        area.setText("");
        for (int i=0;i<contador;i++){
            if (contactos[i]!=null){
                if (agregados==0) {
                    area.setText(contactos[i].toString());
                    agregados++;
                }else{
                    area.setText(area.getText()+"\n\n"+contactos[i].toString());
                    agregados++;
                }
            }
        }
    }
}
