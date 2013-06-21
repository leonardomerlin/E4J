% TEMPLATE UNIOESTE
% Ciência da Computação
%
% Autor: Leonardo Merlin (leonardo.merlin@unioeste.br)
%
\NeedsTeXFormat{LaTeX2e}
\ProvidesPackage{unioeste}
\typeout{UNIOESTE Templating Style - environment}


% All default required packages
%\RequirePackage{float}
\RequirePackage{ifthen}
\RequirePackage{bookmark}

% Packages relativos a linguagem de entrada
\RequirePackage[brazilian]{babel} % nomes e hifenização em português

% Packages relativos a fonte do texto final
\RequirePackage{times}					% usar fonte Times (outra fonte)
\RequirePackage{latexsym}				% simbolos matemticos adicionais

% Packages de auxlio a formatacao
\RequirePackage{alltt}					 % um verbatim melhorado para codigos
% \RequirePackage{doublespace}		 % para setar espacamento entre linhas
\RequirePackage{fancyhdr}				% cabealhos mais sofisticados
\RequirePackage{indentfirst}		  % indentar 1a linha de cada secao
\RequirePackage{vmargin}			  % para setar margens mais facilmente
\RequirePackage{bbm}
\RequirePackage{amsmath}

% Packages relativos a incluso de figuras
\RequirePackage[]{graphicx}		% Permite o uso de figuras .BMP
\RequirePackage{algorithmic}
\RequirePackage{algorithm}
\RequirePackage{clrscode}
\RequirePackage{float}
\RequirePackage[normal]{subfigure}  % permite utilizar subfiguras
\RequirePackage[normalem]{ulem}
\RequirePackage{wrapfig}	 % para permitir o logo da Universidade ao lado do cabealho na capa
\RequirePackage{enumerate}
%Multirow em tabelas
\RequirePackage{multirow}

% Packages relativos s referncias bibliogrficas
%\RequirePackage[alf,abnt-etal-cite=2,abnt-etal-list=0,abnt-etal-text=it]{abntcite}
\RequirePackage [square,numbers]{natbib} % referncias numeradas


% nomeclaturas
\RequirePackage{nomencl}
\makenomenclature
%=======================================================================

% Dimenses a ocupar na pgina (package vmargin)
\setpapersize[portrait]{A4}
\setmarginsrb{30mm} % margem esquerda
				{35mm} % margem superior com cabealho
				{20mm} % margem direita
				{20mm} % margem inferior
				{0mm}	% altura do espao para cabealho
				{0mm}	% espao entre fim do cabealho e incio do
						% texto
				{10mm}	 % altura do espao para rodap
				{10mm}	 % espao entre fim do texto e fim do rodap


%--------------------------------------------------------------
% Definies para o espaamento entre linhas. -----------------

\newlength{\defbaselineskip}
\setlength{\defbaselineskip}{\baselineskip}
\newcommand{\setlinespacing}[1]%
			  {\setlength{\baselineskip}{#1 \defbaselineskip}}

% Define espaamento simples
\newcommand{\singlespacing}{\setlength{\baselineskip}{\defbaselineskip}}

% Define espaamento "um e meio"
\newcommand{\oneandhalfspacing}{\setlength{\baselineskip}
									{1.5 \defbaselineskip}}

% Define espaçamento duplo
\newcommand{\doublespacing}{\setlength{\baselineskip}
									{2.0 \defbaselineskip}}

%------------------------------------------------------------
% Hifenizao das palavras desconhecidas
% Siga o modelo abaixo para hifenizar as palavras que o latex desconhece:
% \hyphenation{a-na-li-sa-dos}
%---------------------------------------------------------------

% Este espaço entre linhas parece ser o mais apropriado
\oneandhalfspacing

% Ser indulgente no preenchimento das linhas
\sloppy

\makeindex

\makeglossary


% EOF `unioeste.sty'.
