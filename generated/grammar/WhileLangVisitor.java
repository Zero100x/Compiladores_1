// Generated from grammar/WhileLang.g4 by ANTLR 4.13.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link WhileLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface WhileLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(WhileLangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(WhileLangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(WhileLangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(WhileLangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(WhileLangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(WhileLangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(WhileLangParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(WhileLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(WhileLangParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link WhileLangParser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(WhileLangParser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringExpr(WhileLangParser.StringExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code numberExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberExpr(WhileLangParser.NumberExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code comparisonExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpr(WhileLangParser.ComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arithmeticExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithmeticExpr(WhileLangParser.ArithmeticExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(WhileLangParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link WhileLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(WhileLangParser.IdExprContext ctx);
}