def call() {
  sh "date"
  echo "hello shubham" 
}

def test(name) {
  sh "date"
  echo "{$name}" 
}

def code() {
sh "git branch: 'main', url: 'https://github.com/OT-MICROSERVICES/attendance-api.git"
}
