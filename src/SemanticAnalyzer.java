public class SemanticAnalyzer extends WhileLangBaseVisitor<Type> {

    private final SymbolTable symbolTable = new SymbolTable();
    private final ErrorReporter errorReporter;

    public SemanticAnalyzer(ErrorReporter errorReporter) {
        this.errorReporter = errorReporter;
    }

    @Override
    public Type visitProgram(WhileLangParser.ProgramContext ctx) {
        for (WhileLangParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }
        return Type.ERROR;
    }

    @Override
    public Type visitDeclaration(WhileLangParser.DeclarationContext ctx) {
        String varName = ctx.ID().getText();
        Type declaredType = visit(ctx.type());
        Type exprType = visit(ctx.expr());

        if (!symbolTable.declare(varName, declaredType)) {
            errorReporter.report("Redeclaración de variable en el mismo ámbito: " + varName);
            return Type.ERROR;
        }

        if (declaredType != exprType && exprType != Type.ERROR) {
            errorReporter.report(
                "Asignación de tipo incorrecto en declaración de '" + varName +
                "'. Se esperaba " + declaredType + " pero se obtuvo " + exprType
            );
        }

        return declaredType;
    }

    @Override
    public Type visitAssignment(WhileLangParser.AssignmentContext ctx) {
        String varName = ctx.ID().getText();
        Type varType = symbolTable.lookup(varName);

        if (varType == null) {
            errorReporter.report("Variable no declarada: " + varName);
            return Type.ERROR;
        }

        Type exprType = visit(ctx.expr());

        if (varType != exprType && exprType != Type.ERROR) {
            errorReporter.report(
                "Asignación de tipo incorrecto a '" + varName +
                "'. Se esperaba " + varType + " pero se obtuvo " + exprType
            );
        }

        return varType;
    }

    @Override
    public Type visitType(WhileLangParser.TypeContext ctx) {
        if (ctx.INT() != null) {
            return Type.INT;
        } else if (ctx.STRING_TYPE() != null) {
            return Type.STRING;
        }
        return Type.ERROR;
    }

    @Override
    public Type visitWhileStatement(WhileLangParser.WhileStatementContext ctx) {
        Type conditionType = visit(ctx.expr());

        if (conditionType != Type.BOOLEAN && conditionType != Type.ERROR) {
            errorReporter.report("La condición del while debe ser booleana.");
        }

        symbolTable.enterLoop();
        visit(ctx.block());
        symbolTable.exitLoop();

        return Type.ERROR;
    }

    @Override
    public Type visitIfStatement(WhileLangParser.IfStatementContext ctx) {
        Type conditionType = visit(ctx.expr());

        if (conditionType != Type.BOOLEAN && conditionType != Type.ERROR) {
            errorReporter.report("La condición del if debe ser booleana.");
        }

        visit(ctx.block(0));

        if (ctx.block().size() > 1) {
            visit(ctx.block(1));
        }

        return Type.ERROR;
    }

    @Override
    public Type visitBlock(WhileLangParser.BlockContext ctx) {
        symbolTable.enterScope();

        for (WhileLangParser.StatementContext stmt : ctx.statement()) {
            visit(stmt);
        }

        symbolTable.exitScope();
        return Type.ERROR;
    }

    @Override
    public Type visitBreakStatement(WhileLangParser.BreakStatementContext ctx) {
        if (!symbolTable.isInsideLoop()) {
            errorReporter.report("'break' usado fuera de un while.");
        }
        return Type.ERROR;
    }

    @Override
    public Type visitContinueStatement(WhileLangParser.ContinueStatementContext ctx) {
        if (!symbolTable.isInsideLoop()) {
            errorReporter.report("'continue' usado fuera de un while.");
        }
        return Type.ERROR;
    }

    @Override
    public Type visitIdExpr(WhileLangParser.IdExprContext ctx) {
        String varName = ctx.ID().getText();
        Type varType = symbolTable.lookup(varName);

        if (varType == null) {
            errorReporter.report("Variable no declarada: " + varName);
            return Type.ERROR;
        }

        return varType;
    }

    @Override
    public Type visitNumberExpr(WhileLangParser.NumberExprContext ctx) {
        return Type.INT;
    }

    @Override
    public Type visitStringExpr(WhileLangParser.StringExprContext ctx) {
        return Type.STRING;
    }

    @Override
    public Type visitParenExpr(WhileLangParser.ParenExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Type visitArithmeticExpr(WhileLangParser.ArithmeticExprContext ctx) {
        Type left = visit(ctx.expr(0));
        Type right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        if (op.equals("+")) {
            if (left == Type.INT && right == Type.INT) {
                return Type.INT;
            }
            if (left == Type.STRING && right == Type.STRING) {
                return Type.STRING;
            }

            errorReporter.report("Operación '+' inválida entre tipos " + left + " y " + right);
            return Type.ERROR;
        }

        if (left == Type.INT && right == Type.INT) {
            return Type.INT;
        }

        errorReporter.report("Operación aritmética inválida entre tipos " + left + " y " + right);
        return Type.ERROR;
    }

    @Override
    public Type visitComparisonExpr(WhileLangParser.ComparisonExprContext ctx) {
        Type left = visit(ctx.expr(0));
        Type right = visit(ctx.expr(1));
        String op = ctx.getChild(1).getText();

        if (op.equals("<") || op.equals(">") || op.equals("<=") || op.equals(">=")) {
            if (left == Type.INT && right == Type.INT) {
                return Type.BOOLEAN;
            }
            errorReporter.report(
                "Comparación inválida con operador '" + op +
                "' entre tipos " + left + " y " + right
            );
            return Type.ERROR;
        }

        if (op.equals("==") || op.equals("!=")) {
            if (left == right && left != Type.ERROR) {
                return Type.BOOLEAN;
            }
            errorReporter.report("Comparación inválida entre tipos " + left + " y " + right);
            return Type.ERROR;
        }

        return Type.ERROR;
    }
}