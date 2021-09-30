# Hexagonal Architecture


### Dicas

#### Como sabemos se é uma validação de entrada ou regra de negócio?
- para validarmos algum e precisamos acessar nosso dominio, é uma regra de negócio
-para validarmos algum e não precisamos necessariamente acessar o domain, é uma validação de entrada.
- exemplo:
  - valor da conta precisa ser maior que zero. Não há necessidade acessar o dominio para tal checagem, pode ser realizada uma validação de entrada. 
  - o codigo desse imposto precisa de um calculo diferenciado. Tenho que acessar meu domínio para tal checagem.
