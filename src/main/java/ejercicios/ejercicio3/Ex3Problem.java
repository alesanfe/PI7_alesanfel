package main.java.ejercicios.ejercicio3;

import main.java.tool.Problem;
import us.lsi.common.List2;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public record Ex3Problem(Integer id, Integer tiempoProduccionRestante,
                         Integer tiempoManualRestante) implements Problem {

    public static Ex3Problem of(Integer id, Integer tiempoProduccionRestante, Integer tiempoManualRestante) {
        return new Ex3Problem(id, tiempoProduccionRestante, tiempoManualRestante);
    }

    // Datos para el problema.
    public static Ex3Problem initialVertex() {
        return of(0, DataEx3.getMaxTiempoEnProduccion(), DataEx3.getMaxTiempoEnManual());
    }

    public List<Integer> actions() {
        return (id >= DataEx3.getNumProductos()) ?
                List2.empty() :
                IntStream.rangeClosed(0, DataEx3.getRatioUnidades(id, tiempoProduccionRestante, tiempoManualRestante))
                        .boxed().toList();
    }

    public Ex3Problem neighbor(Integer a) {
        return of(id + 1,
                tiempoProduccionRestante - DataEx3.getTiempoTotalProduccionProducto(id) * a,
                tiempoManualRestante - DataEx3.getTiempoTotalManualProducto(id) * a);
    }

    public Boolean goal() {
        return Objects.equals(id, DataEx3.getNumProductos());
    }

    public Integer weight(Integer a) {
        return DataEx3.getIngresos(id) * a;
    }
}
