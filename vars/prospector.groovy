def call() {
    def VENV_DIR = "venv"

    sh """
        set -e
        ${VENV_DIR}/bin/pip install --upgrade pip setuptools wheel
        ${VENV_DIR}/bin/pip install pipreqs
        ${VENV_DIR}/bin/pip install prospector --no-deps
        ${VENV_DIR}/bin/prospector --format HTML --output prospector.html full --profile strict || true
    """
}
