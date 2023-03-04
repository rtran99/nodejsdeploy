pipeline {
    agent any
    options {
        docker {
            image 'docker:latest'
            args '--privileged'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'docker build -t my-docker-image .'
            }
        }
        stage('Deploy') {
            steps {
                sshPublisher(
                    continueOnError: true, 
                    failOnError: false,
                    publishers: [
                        sshPublisherDesc(
                            configName: 'my-ssh-server',
                            verbose: true,
                            transfers: [
                                sshTransfer(
                                    sourceFiles: 'Dockerfile index.js package-lock.json package.json',
                                    removePrefix: '/',
                                    execCommand: 'docker build -t my-docker-image . && docker run -p 3000:3000 my-docker-image'
                                )
                            ]
                        )
                    ]
                )
            }
        }
    }
}
