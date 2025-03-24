def call() {
    def PYTHON = "/usr/bin/python3"
    def VENV_DIR = "venv"

    sh """
        set -e  # Stop the script on errors
       ${VENV_DIR} pip install pipreqs prospector
        
        # Run Prospector for static analysis
       ${VENV_DIR} prospector --output-format full --profile strict || true
    """
}
