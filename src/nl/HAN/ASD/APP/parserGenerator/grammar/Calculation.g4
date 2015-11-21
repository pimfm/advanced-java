grammar Calculation;

prog:	(expr NEWLINE)* ;
expr:	expr ('*'|'/') expr
    |	expr ('+'|'-') expr
    |	(INT | DOUBLE)
    |	'(' expr ')';

NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
DOUBLE  : [0-9]+ '.' [0-9]+;
