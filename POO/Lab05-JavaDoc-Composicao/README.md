# Lab 05 — Documentação JavaDoc (projeto Composição)

Versão do laboratório de **Composição de Classes** (Drone + Boat + Motor +
Battery) **documentada com JavaDoc**, para o tópico 05 (Desenho de Aplicações
/ Documentação).

## O que está aqui

- **Código-fonte** (`.java`) com comentários JavaDoc (`/** ... */`) em todas as
  classes, métodos e atributos relevantes, usando as tags `@author`, `@param`,
  `@return` e `{@link ...}`.
- **`doc/`** — a documentação em HTML **gerada** a partir desses comentários.
  Abre o `doc/index.html` no browser para a veres.

## Como foi gerado (e como regenerar)

**No NetBeans:** `Run > Generate JavaDoc (NomeProjeto)`. A documentação fica
tipicamente em `NomeProjeto/target/site/apidocs`.

**No terminal:**
```bash
javadoc -encoding UTF-8 -charset UTF-8 -d doc -author *.java
```

Para verificar conformidade da documentação no NetBeans: `Tools > Analyze JavaDoc`.

## Tags JavaDoc usadas

| Tag | Para que serve |
|-----|----------------|
| `@author` | autor da classe |
| `@param` | descreve um parâmetro de um método |
| `@return` | descreve o valor devolvido |
| `{@link Classe}` | cria uma ligação para outra classe/método |

> Nota: isto é um **exemplo pronto** para aprenderes o formato. Confirma com o
> professor qual o projeto exato a documentar e aplica o mesmo método.
