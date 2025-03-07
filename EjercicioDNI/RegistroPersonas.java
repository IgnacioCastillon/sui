package EjercicioDNI;

public class RegistroPersonas {
    private Persona[] personas = new Persona[10];
    int numPersonas = 0;




    public void agregarPersona(Persona p) {
            String DNI = p.getDni();
            if (numPersonas >2 ) {
            for (int i = 0; i < numPersonas; i++) {
            if (!DNI.equalsIgnoreCase(personas[i].getDni())) {
                personas[numPersonas] = new Persona(p.getNombre(),p.getEdad(),p.getDni());
                numPersonas++;
            }else throw new DniDuplicadoException("ERROR: Este dni ya esta registrado.");
            }
            }else { p = new Persona(p.getNombre(),p.getEdad(),p.getDni());
            numPersonas++;}
    }


    public void buscarPorNombre(String nombre) {
        for (int i = 0; i < numPersonas; i++) {
        if (personas[i]!= null&&nombre.equalsIgnoreCase(personas[i].getNombre())) {
            personas[i].mostrarInfo();
        }else System.out.println("Ninguna persona registrada con ese nombre");
        }
    }

    public void listarPersonas() {
        if (numPersonas == 0) {
            System.out.println("No hay personas");
        }else {
            System.out.println("\nListado de personas: ");
            for (int i = 0; i < numPersonas; i++) {
                if (personas[i] != null) {
                    System.out.println(personas[i].getNombre());
                    System.out.println(personas[i].getEdad());
                    System.out.println(personas[i].getDni());
                }
            }
        }
    }
}
