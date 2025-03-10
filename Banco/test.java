package Banco;

public class test {
        public static void main(String[] args) {
            // Creación de dos cuentas bancarias
            CuentaBancario cuenta1 = new CuentaBancario("Ana García", 1000);
            CuentaBancario cuenta2 = new CuentaBancario("Luis Martínez", 500);

            try {
                // Realizar operaciones:
                cuenta1.depositar(300);             // Depósito de 300€ en la cuenta1
                cuenta1.reintengro(200);            // Reintegro de 200€ en la cuenta1
                cuenta1.transferir(cuenta2, 400);   // Transferencia de 400€ de cuenta1 a cuenta2

                // Probamos con valores inválidos para observar el manejo de excepciones:
                // cuenta1.depositar(0);
                // cuenta1.reintengro(-50);
                // cuenta1.reintengro(2000);

            } catch (DepositoInvalidoException | ReintegroInvalidoException | SaldoInsuficienteException e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println();
            System.out.printf("Saldo de %s : %.2f€%n", cuenta1.getNombre(), cuenta1.getSaldo());
            System.out.printf("Saldo de %s : %.2f€%n", cuenta2.getNombre(), cuenta2.getSaldo());
            System.out.println();

            // Mostrar el historial de transacciones de cada cuenta
            cuenta1.mostrarHistorial();
            System.out.println();
            cuenta2.mostrarHistorial();
        }
    }

