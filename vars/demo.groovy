def call(name) {
   echo "${name}"
}
def cleanWorkspace() {
   sh ' cleanWs()' // Alternative to cleanWs if the cleanWs plugin isn't available
}
def gitCheckout(String branch, String repoUrl ) {
    script {
        echo "Checking out branch: ${branch} from repository: ${repoUrl}"

        checkout([
            $class: 'GitSCM',
            branches: [[name: branch]],
            userRemoteConfigs: [[url: repoUrl]]
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
   JAVA_OPTS="-Dnvd.api.key=39ba0629-d86f-4aa2-98de-43726b700c23" ./dependency-check/bin/dependency-check.sh --scan . --format HTML --out dependency-report.html
   '''
}
