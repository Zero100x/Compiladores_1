import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Main <archivo_fuente>");
            return;
        }

        try {
            String input = Files.readString(Paths.get(args[0]));

            CharStream charStream = CharStreams.fromString(input);
            WhileLangLexer lexer = new WhileLangLexer(charStream);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            WhileLangParser parser = new WhileLangParser(tokens);

            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg,
                                        RecognitionException e) {
                    System.out.println("Error sintáctico en línea " + line + ":" + charPositionInLine + " -> " + msg);
                }
            });

            ParseTree tree = parser.program();

            ErrorReporter errorReporter = new ErrorReporter();
            SemanticAnalyzer analyzer = new SemanticAnalyzer(errorReporter);
            analyzer.visit(tree);

            errorReporter.printErrors();

        } catch (Exception e) {
            System.out.println("Error al ejecutar el análisis: " + e.getMessage());
            e.printStackTrace();
        }
    }
}