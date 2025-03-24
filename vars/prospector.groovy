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
        
        # Upgrade pip and install dependencies
        pip install --upgrade pip
        pip install pipreqs prospector
        
        # Generate requirements file
        pipreqs . --force

        # Run Prospector for static analysis
        prospector --output-format full --profile strict || true
    """
}
