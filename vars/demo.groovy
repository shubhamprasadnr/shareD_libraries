def call() {
    cleanWs()
}

def code_checkout(String branch, String repoUrl, String credentialsId) {
    git branch: branch, url: repoUrl, credentialsId: credentialsId
}

def call() {
    sh '''
        wget https://github.com/gitleaks/gitleaks/releases/download/v8.24.0/gitleaks_8.24.0_linux_x64.tar.gz
        tar -xzvf gitleaks_8.24.0_linux_x64.tar.gz
        chmod +x gitleaks
        sudo mv gitleaks /usr/local/bin/
    '''
}
def call(String reportName) {
    sh "gitleaks detect -r ${reportName}"
}

def call(String reportName) {
    archiveArtifacts artifacts: reportName, fingerprint: true
}

