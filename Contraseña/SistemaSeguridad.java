package Contraseña;

public class SistemaSeguridad {
    private String claveCorrecta = "Banana";
    private int fallosConsecutivos= 0;
    private long lockExpirationTime = 0;
    private long baseLockDuration = 30000;
    private int lockMultiplier = 1;
    private Intento[] historial = new Intento[10];
    private int numIntentos= 0;



    public void acceder(String clave){
        if (System.currentTimeMillis()>lockExpirationTime){
            if (claveCorrecta.equals(clave)){
                numIntentos++;
                this.registrarIntento(clave);
                fallosConsecutivos=0;
                lockMultiplier = 0;
            }else{
                fallosConsecutivos++;
                this.registrarIntento(clave);
                if (fallosConsecutivos==3){
                    lockExpirationTime = System.currentTimeMillis() + (baseLockDuration * lockMultiplier);
                    lockMultiplier++;
                    fallosConsecutivos=0;
                    throw new DemasiadosIntentosException("Has alcanzado demasiados intentos fallidos.");
                }else throw new CredencialesIncorrectasException("Intentos fallidos: "+fallosConsecutivos);
            }
        }else {
            long tiempoRestante = (lockExpirationTime - System.currentTimeMillis()) / 1000;
            throw new CuentaBloqueadaException("Quedan " + tiempoRestante + " segundos de bloqueo.");
        }
        }
    int intentosalreves = historial.length;
    boolean completo = false;
    private void registrarIntento(String resultado) {
            if (completo) {
                for (int i = historial.length-1; i > 0; i--) {
                    historial[i] = historial[i-1];
                }
                historial[0] = new Intento(resultado);
            }else {
                if (intentosalreves >= 0) {
                    intentosalreves--;
                    historial[intentosalreves]= new Intento(resultado);
                    if (intentosalreves==0){
                        completo = true;
                    }
                }
            }
    }
    public void mostrarHistorial() {
        System.out.println("Historial de intentos:");
        for (int i = 0; i < historial.length; i++) {
            if (historial[i] != null) {
                System.out.println(historial[i]);
            }
        }
    }

}
