grammar WhileLang;

program
    : statement+ EOF
    ;

statement
    : declaration
    | assignment
    | whileStatement
    | ifStatement
    | breakStatement
    | continueStatement
    ;

declaration
    : type ID ASSIGN expr SEMI
    ;

assignment
    : ID ASSIGN expr SEMI
    ;

type
    : INT
    | STRING_TYPE
    ;

whileStatement
    : WHILE LPAREN expr RPAREN block
    ;

ifStatement
    : IF LPAREN expr RPAREN block (ELSE block)?
    ;

block
    : LBRACE statement* RBRACE
    ;

breakStatement
    : BREAK SEMI
    ;

continueStatement
    : CONTINUE SEMI
    ;

expr
    : ID                                       # idExpr
    | NUMBER                                   # numberExpr
    | STRING                                   # stringExpr
    | LPAREN expr RPAREN                       # parenExpr
    | expr (MULT | DIV) expr                   # arithmeticExpr
    | expr (PLUS | MINUS) expr                 # arithmeticExpr
    | expr (LT | GT | GE | LE | EQ | NE) expr  # comparisonExpr
    ;

INT         : 'int';
STRING_TYPE : 'string';
WHILE       : 'while';
IF          : 'if';
ELSE        : 'else';
BREAK       : 'break';
CONTINUE    : 'continue';

LPAREN : '(';
RPAREN : ')';
LBRACE : '{';
RBRACE : '}';
SEMI   : ';';
ASSIGN : '=';

GT : '>';
LT : '<';
GE : '>=';
LE : '<=';
EQ : '==';
NE : '!=';

PLUS  : '+';
MINUS : '-';
MULT  : '*';
DIV   : '/';

ID     : [a-zA-Z_][a-zA-Z_0-9]*;
NUMBER : [0-9]+;
STRING : '"' (~["\\] | '\\' .)* '"';

WS : [ \t\r\n]+ -> skip;