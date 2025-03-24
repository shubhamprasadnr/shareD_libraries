def call() {
def PYTHON = "/usr/bin/python3"
def VENV_DIR = "venv"
   sh '''
                 ${PYTHON} -m venv ${VENV_DIR}
                 ${VENV_DIR}/bin/pip install --upgrade pip
                 ${VENV_DIR}/bin/pip install pipreqs
                 ${VENV_DIR}/bin/pipreqs . --force
                 '''
}
