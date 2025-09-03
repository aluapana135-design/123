from flask import Flask, jsonify

app = Flask(__name__)


@app.route('/dados')
def get_data():
    
    return jsonify(response)

# O servidor roda no seu computador, acessível na rede local pela porta 5000.
if __name__ == '__main__':
    app.run(host='0.0.0.0', port=5000)