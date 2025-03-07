package ejerciciocontra;

public class Usuario {
    private String password;
    private String[] historialPasswords = new String[3];
    private int numHistorial;

    public Usuario() {
    }

    public Usuario(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public String[] getHistorialPasswords() {
        return historialPasswords;
    }

    public void setHistorialPasswords(String[] historialPasswords, String nuevacontra) {
        this.historialPasswords = historialPasswords;
    }

    public int getNumHistorial() {
        return numHistorial;
    }

    public void setNumHistorial(int numHistorial) {
        this.numHistorial = 0;
    }

    public void mostrarHistorial() {
        System.out.println("\nHistorial: ");
        if (numHistorial == 1) {
            System.out.println(historialPasswords[0]);
        } else if (numHistorial==2) {
            System.out.println(historialPasswords[0]);
            System.out.println(historialPasswords[1]);
        }else{
            System.out.println(historialPasswords[0]);
            System.out.println(historialPasswords[1]);
            System.out.println(historialPasswords[2]);
        }
    }

    public void actualizarHistorial(String nuevaPassword) {
        if (numHistorial == 0) {
            historialPasswords[numHistorial] = nuevaPassword;
            numHistorial++;
        } else if (numHistorial == 1) {
            historialPasswords[numHistorial] = historialPasswords[0];
            historialPasswords[0] = nuevaPassword;
            numHistorial++;
        } else if (numHistorial >= 2) {
            historialPasswords[2] = historialPasswords[1];
            historialPasswords[1] = historialPasswords[0];
            historialPasswords[0] = nuevaPassword;
            numHistorial++;
        }
    }


    public String setPassword(String nuevaPassword) throws PasswordInvalidaException,PasswordRepetidaException {
        boolean mayuscula = false, minuscula = false, numerico = false, especial = false, valida = false;
        for (char ch : nuevaPassword.toCharArray()) {
            if (Character.isUpperCase(ch)) mayuscula = true;
            else if (Character.isLowerCase(ch)) minuscula = true;
            else if (Character.isDigit(ch)) numerico = true;
            else especial = true;

        }
        if (!nuevaPassword.equals(password) && !nuevaPassword.equals(historialPasswords[0]) && !nuevaPassword.equals(historialPasswords[1]) && !nuevaPassword.equals(historialPasswords[2])){
            if (nuevaPassword.length() >= 8 && mayuscula && minuscula && numerico && especial) {
                this.password = nuevaPassword;
                valida = true;
            }
             else
                throw new PasswordInvalidaException("ERROR: La contraseña debe contener al menos una letra minuscula, mayuscula, numero y caracter especial.");
        }else throw new PasswordRepetidaException("ERROR: La contraseña nueva no puede ser igual a una usada recientemente");


        return password;
        }
    }
