import java.util.ArrayList;
import java.util.List;

public class ErrorReporter {
    private final List<String> errors = new ArrayList<>();

    public void report(String message) {
        errors.add(message);
    }

    public boolean hasErrors() {
        return !errors.isEmpty();
    }

    public void printErrors() {
        if (!hasErrors()) {
            System.out.println("Análisis semántico completado sin errores.");
            return;
        }

        System.out.println("Se encontraron errores semánticos:");
        for (String error : errors) {
            System.out.println("- " + error);
        }
    }
}