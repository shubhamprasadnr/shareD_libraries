def call(name) {
   echo "${name}"
}

def gitCheckout(String branch, String repoUrl, String credentialsId = '') {
    script {
        echo "Checking out branch: ${branch} from repository: ${repoUrl}"

        checkout([
            $class: 'GitSCM',
            branches: [[name: branch]],
            userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
        ])
    }
}

def gitleaks() {
    sh '''
        wget https://github.com/gitleaks/gitleaks/releases/download/v8.24.0/gitleaks_8.24.0_linux_x64.tar.gz
        tar -xzvf gitleaks_8.24.0_linux_x64.tar.gz
        chmod +x gitleaks
        sudo mv gitleaks /usr/local/bin/
    '''
}
def report(String reportName) {
    sh "gitleaks detect -r ${reportName}"
}

def archive(String reportName) {
    archiveArtifacts artifacts: reportName, fingerprint: true
}

