pipeline {
  agent any
  
  stages {
    stage('Build Docker Image') {
      steps {
        sh 'sudo docker build -t my-docker-image .'
      }
    }

    stage('Run Docker Container') {
      steps {
        sh 'sudo docker run -p 8080:8080 my-docker-image'
      }
    }
  }
}
