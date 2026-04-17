// Generated from grammar/WhileLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link WhileLangParser}.
 */
public interface WhileLangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(WhileLangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(WhileLangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(WhileLangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(WhileLangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(WhileLangParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(WhileLangParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(WhileLangParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(WhileLangParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(WhileLangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(WhileLangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(WhileLangParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(WhileLangParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(WhileLangParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(WhileLangParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(WhileLangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(WhileLangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(WhileLangParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(WhileLangParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link WhileLangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(WhileLangParser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link WhileLangParser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(WhileLangParser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStringExpr(WhileLangParser.StringExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStringExpr(WhileLangParser.StringExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(WhileLangParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(WhileLangParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpr(WhileLangParser.ComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpr(WhileLangParser.ComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arithmeticExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArithmeticExpr(WhileLangParser.ArithmeticExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arithmeticExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArithmeticExpr(WhileLangParser.ArithmeticExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(WhileLangParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(WhileLangParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(WhileLangParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(WhileLangParser.IdExprContext ctx);
}