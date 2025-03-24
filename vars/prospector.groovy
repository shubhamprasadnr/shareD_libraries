def call() {
    def PYTHON = "/usr/bin/python3"
    def VENV_DIR = "venv"

    sh """
        set -e  # Stop the script on errors
        pip install pipreqs prospector
        
        # Run Prospector for static analysis
        prospector --output-format full --profile strict || true
    """
}
