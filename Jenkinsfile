pipeline {
    agent any
    stages {
        stage('Build Docker Image') {
            steps {
                sh 'docker build --no-cache -t my-docker-image .'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'docker run --privileged -d -p 80:3000 my-docker-image'
            }
        }
    }
}
