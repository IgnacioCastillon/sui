package EjercicioDni;

public class Persona {
    private String nombre;
    private int edad;
    private String dni;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
        this.nombre = nombre;
        this.edad = edad;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) throws EdadInvalidaException {
        if (edad<0 || edad>150){
            throw new EdadInvalidaException("La edad debe estar entre 0 y 150");
        }else this.edad = edad;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DniInvalidoException {
        int numeros = 0;
        for (char cd : dni.toCharArray()){
            if (dni.length()==9&&Character.isDigit(cd)&&numeros!=8){
                numeros++;
            } else if (Character.isLetter(cd)&&numeros==8) {

                this.dni = dni;
            }else throw new DniInvalidoException("Error: El dni no esta correctamente formado.");
        }
    }
    public boolean esMayorDeEdad(){
        if (edad>=18){
            System.out.println("\n"+nombre+" si es mayor de edad\n");
            return true;
        }else {
            System.out.println("\n"+nombre+" no es mayor de edad\n");
            return false;
        }
    }
    public void actualizarDatos(String nombre, int edad, String dni){
        try {
            setNombre(nombre);
            setEdad(edad);
            setDni(dni);
            System.out.println("\nDatos Actualizados para el usuario "+nombre);
        }catch (EdadInvalidaException | DniInvalidoException e){
            System.out.println(e.getMessage());
        }
    }

    public void mostrarInfo(){
        System.out.println("Nombre\t|\tEdad\t|\tDNI");
        System.out.println(getNombre()+"\t|\t"+getEdad()+"\t\t|\t"+getDni());
    }
}
