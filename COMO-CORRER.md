# Como ver os trabalhos enquanto mexo neles

Guia rápido para abrir e testar os trabalhos da cadeira de Programação Web
no VS Code. Há **dois tipos de trabalho** na pasta `ProgWeb`, e cada um
vê-se de maneira diferente.

---

## Tipo A — HTML simples (ex.: `ProgWeb/AP01/`)

Ficheiros `.html` soltos (`ListaAlunos.html`, `raquel.html`). Não precisam
de servidor.

1. Instalar a extensão **Live Server** no VS Code
   (Ctrl+Shift+X → procurar "Live Server" da Ritwick Dey → Install).
2. Botão direito no ficheiro `.html` → **Open with Live Server**.
3. Abre em `http://127.0.0.1:5500`. Ao gravar (Ctrl+S), o browser faz
   **refresh automático**.

---

## Tipo B — Servidor Flask (pastas `WebServer-...`)

São servidores em Python (Flask). **Não** abrir o `.html` à bruta — é o
`Server.py` que gera as páginas. É preciso arrancar o servidor primeiro.

No terminal do VS Code (Ctrl+`), **dentro da pasta do servidor**:

### Primeira vez (cria o ambiente e instala o Flask)

```bash
# Windows
setup-Env.bat

# Mac / Linux
bash setup-Env.sh
```

### Arrancar o servidor (sempre que quiser ligar o site)

```bash
# Windows
go-Server.bat

# Mac / Linux
bash go-Server.sh
```

Depois abrir o browser em **http://localhost** (porta 80, definida no
`environment.sh` / `environment.bat`).

Para **parar** o servidor: `Ctrl+C` no terminal.

---

## Avisos importantes

1. **Porta 80 dá erro de permissão?** No Mac/Linux a porta 80 costuma
   exigir admin. Abrir `environment.sh` (ou `environment.bat`) e mudar
   `Port=80` para `Port=8080`. Aceder então em **http://localhost:8080**.

2. **Auto-reload:** o servidor tem `TEMPLATES_AUTO_RELOAD` ligado, por isso
   mudanças num `.html` em `templates/` veem-se só com refresh no browser.
   Mas se mexer no **`Server.py`** (código Python), tem de **parar**
   (Ctrl+C) e **arrancar outra vez**.

---

## Resumo do fluxo de trabalho

| Trabalho | Como ver |
|----------|----------|
| Pasta `AP01` (HTML solto) | Live Server → vê logo |
| Pasta `WebServer-...` (Flask) | Correr `go-Server` uma vez, deixar o terminal aberto, dar refresh no `localhost` |
