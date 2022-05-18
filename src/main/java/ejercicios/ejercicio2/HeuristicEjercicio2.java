package main.java.ejercicios.ejercicio2;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class HeuristicEjercicio2 {

    /**
     * Suma la valoración de todos los candidatos que aún no han sido analizados.
     *
     * @param source el vértice origen.
     * @param goal   restricción que indica que no quedan más vértices por analizar.
     * @param target el vértice destino.
     * @return la valoración total menos los candidatos ya analizados.
     */
    public static Double heuristic(ProblemEjercicio2 source, Predicate<ProblemEjercicio2> goal, ProblemEjercicio2 target) {
        return IntStream.range(source.indice(), DataEjercicio2.getNumCandidatos())
                .map(DataEjercicio2::getValoracion)
                .sum() * 1.0;
    }

    private HeuristicEjercicio2() {
    }
}