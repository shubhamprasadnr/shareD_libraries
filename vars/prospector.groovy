def call() {
    def PYTHON = "/usr/bin/python3"
    def VENV_DIR = "venv"

    sh """
        set -e  # Stop the script on errors
        
        # Create a virtual environment if not exists
        if [ ! -d "${VENV_DIR}" ]; then
            ${PYTHON} -m venv ${VENV_DIR}
        fi
        
        # Activate the virtual environment
        . ${VENV_DIR}/bin/activate
        pip install pipreqs prospector
        
        # Run Prospector for static analysis
        prospector --output-format full --profile strict || true
    """
}
