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
def report(repoPath = ".") {
    echo "Running Gitleaks scan..."

    sh '''
        sh "gitleaks detect --source . -r ${repoPath.json} || true"
     '''

    echo "Gitleaks scan completed! Report generated in HTML format."
}

// def archive(String reportName) {
//     archiveArtifacts artifacts: reportName, fingerprint: true
// }

