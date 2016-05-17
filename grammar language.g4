grammar language Programmes;

// Programmes
p : i
  | d*
  | 'var ('x ':'' t')' ;

// Fonctions
d : i
  | var '(' x ':' t ')'
  | 'f((' x ':' t ')' * ') [: ' t ']' ;

// Instructions
i : x ':=' e 
  | e'['e']' : = e
  | 'if' e 'then' e 'else' e
  | 'while' e 'do' i
  | phi'('e*')'
  | 'skip'
  | i ;

// Expressions
e : k
  | x
  | 'uop' e
  | e 'bop' e
  | phi'('e*')''
  | e'['e']'
  | 'array of' t '[' e '] ; 

// Cibles d'appels
phi : 'read'
	| 'write'
	| f ;

// Opérateurs binaires
bop : '+'
	| '-'
	| 'x'
	| '/'
	| 'and'
	| 'or'
	| '<'
	| '<='
	| '='
	| '!='
	| '>='
	| '>';

// Opérateurs unaires
uop : '-'
	| 'not';

// Constantes
k : n
  | 'true'
  | 'false' ; 

// Nombre
n : [0-9]*;

// Types
t : 'int'
  | 'boolean'
  | 'array of' t ;

// Entrées
x : [a-zA-Z]*
  | [0-9]* ;

// Automatique
WS : [ \r\t\n]+ -> channel(WHITESPACE_CHANNEL) ;

SL_COMMENT
    :   '//' .*? '\n' -> skip
    ;