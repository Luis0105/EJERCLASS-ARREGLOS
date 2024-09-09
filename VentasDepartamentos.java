public class VentasDepartamentos {
    private static final int MESES = 12;
    private static final int DEPARTAMENTOS = 3;
    private double[][] ventas;
    private String[] nombresDepartamentos;
    private String[] nombresMeses;

    public VentasDepartamentos(double[][] ventasIniciales) {
        ventas = ventasIniciales;
        nombresDepartamentos = new String[] {"Ropa", "Deportes", "Juguetería"};
        nombresMeses = new String[] {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };
    }

    public Double buscarVenta(int departamento, int mes) {
        if (0 <= departamento && departamento < DEPARTAMENTOS && 0 <= mes && mes < MESES) {
            return ventas[departamento][mes];
        } else {
            System.out.println("Error: Departamento o mes no válido.");
            return null;
        }
    }

    public void eliminarVenta(int departamento, int mes) {
        if (0 <= departamento && departamento < DEPARTAMENTOS && 0 <= mes && mes < MESES) {
            ventas[departamento][mes] = 0;
            System.out.println("Venta eliminada correctamente.");
            mostrarVentas(); // Muestra las ventas actualizadas después de eliminar
        } else {
            System.out.println("Error: Departamento o mes no válido.");
        }
    }

    public void mostrarVentas() {
        System.out.printf("%-15s", "Mes");
        for (String dept : nombresDepartamentos) {
            System.out.printf("%-15s", dept);
        }
        System.out.println();

        for (int i = 0; i < MESES; i++) {
            System.out.printf("%-15s", nombresMeses[i]);
            for (int j = 0; j < DEPARTAMENTOS; j++) {
                System.out.printf("$%-14.2f", ventas[j][i]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        // Datos de ventas iniciales, puedes ajustar estos valores según sea necesario
        double[][] ventasIniciales = {
            {1000.0, 1500.0, 2000.0, 2500.0, 3000.0, 3500.0, 4000.0, 4500.0, 5000.0, 5500.0, 6000.0, 6500.0},
            {800.0, 1200.0, 1600.0, 2000.0, 2400.0, 2800.0, 3200.0, 3600.0, 4000.0, 4400.0, 4800.0, 5200.0},
            {600.0, 900.0, 1200.0, 1500.0, 1800.0, 2100.0, 2400.0, 2700.0, 3000.0, 3300.0, 3600.0, 3900.0}
        };
        
        VentasDepartamentos ventas = new VentasDepartamentos(ventasIniciales);
        ventas.mostrarVentas();

        // Datos para buscar una venta
        int departamento = 1; // Ejemplo: Deportes
        int mes = 5; // Ejemplo: Junio
        Double ventaEncontrada = ventas.buscarVenta(departamento, mes);
        if (ventaEncontrada != null) {
            System.out.printf("Venta encontrada: $%.2f%n", ventaEncontrada);
        }

        // Datos para eliminar una venta
        departamento = 0; // Ejemplo: Ropa
        mes = 2; // Ejemplo: Marzo
        ventas.eliminarVenta(departamento, mes);
    }
}