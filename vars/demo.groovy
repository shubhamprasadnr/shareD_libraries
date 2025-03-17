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
      
        sudo apt install gitleaks
    '''
}
def report(String reportName) {
    sh "gitleaks detect -r ${reportName}"
}

def archive(String reportName) {
    archiveArtifacts artifacts: reportName, fingerprint: true
}

