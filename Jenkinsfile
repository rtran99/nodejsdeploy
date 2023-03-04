pipeline {
    agent any
    environment { DOCKER_HOST = 'unix:///var/run/docker.sock' }
    stages {
        stage('Build Docker Image') {
            steps {
                sh 'docker build --no-cache -t my-docker-image .'
            }
        }
        stage('Run Docker Container') {
            steps {
                sh 'docker run --name my-docker-container -d my-docker-image'
            }
        }
    }
}
