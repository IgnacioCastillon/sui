package CasoPractico1;

public class RadioPortatil implements Radio{
    @Override
    public void escucharSintonia(String sintonia){
        System.out.printf("Escuchando "+sintonia);
    }
}
