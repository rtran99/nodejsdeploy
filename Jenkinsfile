pipeline {
  agent any
  
  stages {
    stage('Build Docker Image') {
      steps {
        script {
          def dockerImage = docker.build('my-docker-image')
        }
      }
    }

    stage('Run Docker Container') {
      steps {
        script {
          docker.image('my-docker-image').run('-p 8080:8080')
        }
      }
    }
  }
}
