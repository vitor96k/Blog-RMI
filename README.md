# Blog-RMI

Desenvolvimento de um blog utilizando RMI para a disciplina de Sistemas Operacionais - 3º Ano Ciência da Computação.

As operações permitidas no micro blogue:
a) Usuários enviam post em um determinado tópico: post(@username, #tópico, texto)
b) Usuário ingressa em um determinado tópico: follow (@username, #tópico)
c) Usuário deixa de seguir e de acessar um determinado tópico: unsubscribe (@username, #tópico)
d) O usuário recupera todos os posts de todos os tópicos que faz parte, desde a data especificada até a data atual: retrievetime (@username, timestamp)
e) O usuário recupera todos os posts, apenas do tópico identificado (o usuário deve fazer parte do tópico), desde a data especificada até a data atual: retrievetopic(@username, #tópico, timestamp)


Especificações da implementação:

1) Eleição de lider: Todos elementos devem participar da eleição. Implemente uma funcionalidade no cliente,
que exibe a identificação do lider. O processo de eleição será iniciado quando um lider abdicar da liderança.

2) Sincronização de relógio: A função do lider será de servidor de tempo, ou seja, após eleito, os elementos devem sincronizar
seus relógios com o lider (use a solução de Berkeley). Cada elemento deve manter uma variável com o diferença de tempo
entre o relógio local e o relógio do servidor (clock offset).

3) Exclusão Mútua Distribuída: múltiplos clientes podem ler ou escrever (enviar requisições para leitura ou escrita)
simultaneamente na base de dados, use a solução distribuída para obter acesso à base (exclusão mútua). 
Como estamos realizando leituras e escritas, as regras para exclusão mútua serão: cada mensagem de post deve obter uma
permissão de escrita (write) e nenhum outro processo pode obter permissão para leitura ou escrita; as mensagens
para recuperação (leitura) devem obter permissão de leitura (read) na base, no entanto, múltiplas leituras podem ser
realizadas de forma concorrente, mas nenhuma escrita será permitida se houver uma leitura em curso
(resumindo: a leitura permite multiplos acessos para outros leitores, enquanto um acesso de escrita deve ser
realizado de forma única).




