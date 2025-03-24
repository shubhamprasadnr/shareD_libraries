def prospector() {
    def VENV_DIR = "venv"

    sh """
        set -e  # Stop on errors

        # Activate the virtual environment
        . ${VENV_DIR}/bin/activate

        # Ensure dependencies are installed
        pip install --upgrade pip
        pip install pipreqs prospector

        # Run Prospector for static analysis
        prospector --output-format full --profile strict || true
    """
}
