def call() {
    def PYTHON = "/usr/bin/python3"
    def VENV_DIR = "venv"

    sh """
        set -e  # Exit immediately if any command fails
        ${PYTHON} -m venv ${VENV_DIR}
        . ${VENV_DIR}/bin/activate
        pip install --upgrade pip
        pip install pipreqs
        pipreqs . --force
    """
}
