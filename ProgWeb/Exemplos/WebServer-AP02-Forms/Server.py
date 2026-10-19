#
# Importar as bibliotecas necessárias
from flask import Flask, redirect, send_file, request, render_template

import logging
import json

#
# Flask application object (app) no contexto do módulo Python currente
#
app = Flask(__name__)
app.url_map.strict_slashes = False

app.config[ 'TEMPLATES_AUTO_RELOAD' ] = True

#
# Ativar o nível de log para debug
#
logging.basicConfig( level=logging.DEBUG )

#
# Função auxiliar para ler dados JSON (em formato utf-8) de um ficheiro
#
def loadData(fName):
    logging.debug( f"Loading data from {fName}..." )

    with open( fName, encoding='utf-8') as f:
        data = json.load( f )
    f.close()

    return data

#
# Função auxiliar para escrever dados JSON (em formato utf-8) num ficheiro
#
def saveData(fName, data):
    logging.debug( f"Saving data to {fName}..." )

    data_json = json.dumps( data, indent=4)

    with open( fName, "w", encoding='utf-8') as f:
        f.write( data_json )
    f.close()

    return data

@app.route('/favicon.ico')
def getFavicon():
    logging.debug( f"Route /favicon.ico called..." )
    return send_file( "./static/favicon.ico", as_attachment=True, max_age=1 )

#
# Adicionar o tratamento das rotas / e /static e /static/
#
# Redirecionar para a página de index (/static/index.html)
#
@app.route('/')
@app.route('/static')
def getRoot():
    logging.debug( f"Route / called..." )
    return redirect( "/static/index.html", code=302 )

@app.route('/handleFormOla', methods=['GET', 'POST'])
def handleFormOla():
    logging.debug( f"Route handleFormOla called..." )

    nome = None
    if request.method == "POST":
        nome = request.form.get( "nome", "(sem nome POST)" )
    else:
        if request.method == "GET":
            nome = request.args.get( "nome", "(sem nome GET)" )
 
    return render_template( "olaT.html", nome=nome )
