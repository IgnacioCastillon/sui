package EjercicioDni;

public class RegistroPersonas {
    private Persona[] personas = new Persona[10];
    int numPersonas = 0;

    public void agregarPersona(Persona p) {
        String DNI = p.getDni();

        for (int i = 0; i < numPersonas; i++) {
            if (DNI.equalsIgnoreCase(personas[i].getDni())) {
                throw new DniDuplicadoException("\nERROR: Este DNI ya está registrado.\n");
            }
        }

        if (numPersonas < personas.length) {
            personas[numPersonas] = new Persona(p.getNombre(), p.getEdad(), p.getDni());
            numPersonas++;
        } else {
            throw new IllegalStateException("ERROR: No se pueden agregar más personas, el registro está lleno.");
        }
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
            System.out.println("Nombre\t|\tEdad\t|\tDNI");
            for (int i = 0; i < numPersonas; i++) {
                if (personas[i] != null) {
                    System.out.println(personas[i].getNombre()+"\t|\t"+personas[i].getEdad()+"\t\t|\t"+personas[i].getDni());
                }
            }
        }
    }
}
