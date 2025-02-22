def call() {
  sh "date"
  echo "hello shubham" 
}

def test(name) {
  sh "date"
  echo "{$name}" 
}

def prod() {
  sh "date"
  echo "rahul" 
}
