import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
    private final Stack<Map<String, Type>> scopes = new Stack<>();
    private int loopDepth = 0;

    public SymbolTable() {
        enterScope(); // scope global
    }

    public void enterScope() {
        scopes.push(new HashMap<>());
    }

    public void exitScope() {
        if (!scopes.isEmpty()) {
            scopes.pop();
        }
    }

    public boolean declare(String id, Type type) {
        Map<String, Type> currentScope = scopes.peek();
        if (currentScope.containsKey(id)) {
            return false; // redeclaración en el mismo ámbito
        }
        currentScope.put(id, type);
        return true;
    }

    public Type lookup(String id) {
        for (int i = scopes.size() - 1; i >= 0; i--) {
            Map<String, Type> scope = scopes.get(i);
            if (scope.containsKey(id)) {
                return scope.get(id);
            }
        }
        return null; // no encontrada
    }

    public void enterLoop() {
        loopDepth++;
    }

    public void exitLoop() {
        loopDepth--;
    }

    public boolean isInsideLoop() {
        return loopDepth > 0;
    }
}