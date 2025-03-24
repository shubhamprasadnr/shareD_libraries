def call() {
    def VENV_DIR = "venv"

    sh """
        set -e
        ${VENV_DIR}/bin/pip install --upgrade pip setuptools wheel
        ${VENV_DIR}/bin/pip install pipreqs
        ${VENV_DIR}/bin/pip install --upgrade setuptools
       
       ${VENV_DIR}/bin/pip install pylint-flask-extensions flask-pylint
        ${VENV_DIR}/bin/pip install prospector
        ${VENV_DIR}/bin/prospector --format html --output prospector.html

    """
}

// def call() {
//     def VENV_DIR = "venv"

//     sh """
//         set -e
//         ${VENV_DIR}/bin/pip install --upgrade pip setuptools wheel
//         ${VENV_DIR}/bin/pip install pipreqs
//         ${VENV_DIR}/bin/pip install PyYAML  # Ensuring PyYAML is installed
//         ${VENV_DIR}/bin/pip install prospector --no-deps
//         ${VENV_DIR}/bin/prospector --profile strict --format html --output prospector.html
//     """


// }
