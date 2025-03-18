def call(name) {
   echo "${name}"
}
def cleanWorkspace() {
   sh ' cleanWs()' // Alternative to cleanWs if the cleanWs plugin isn't available
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


   def report(String reportFile) {
    sh "gitleaks detect --source . --report-format=json -r ${reportFile} || true"
    echo "Gitleaks report saved as ${reportFile}"
}



// def archive(String reportName) {
//     archiveArtifacts artifacts: reportName, fingerprint: true
// }

def owasp(){
   sh '''
   wget https://github.com/jeremylong/DependencyCheck/releases/download/v12.1.0/dependency-check-12.1.0-release.zip
   sudo apt install unzip
   unzip -n dependency-check-12.1.0-release.zip


   
   '''
}

def owaspscan() {
   sh '''
   ./dependency-check.sh --scan . --format HTML --out dependency-report.html

'''

}
