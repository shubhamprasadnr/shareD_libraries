def call(name) {
   echo name "${name}"
}

// def checkout(String branch, String repoUrl, String credentialsId) {
//     git branch: branch, url: repoUrl, credentialsId: credentialsId
// }



// def checkout(String repoUrl, String branch = 'main', String credentialsId = '') {
//     script {
//         echo "Checking out code from ${repoUrl} on branch ${branch}"
//         checkout([
//             $class: 'GitSCM',
//             branches: [[name: branch]],
//             userRemoteConfigs: [[url: repoUrl, credentialsId: credentialsId]]
//         ])
//     }
// }

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

