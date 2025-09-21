pipeline {
    agent any
    environment {
        MAVEN_HOME = tool 'Maven3'
        JAVA_HOME  = tool 'Java17'
    }
    stages {
        stage('Checkout') { steps { git branch: 'main', url: 'https://github.com/your/repo.git' } }
        stage('Build Backend') { steps { sh "${MAVEN_HOME}/bin/mvn clean package -f backend/pom.xml" } }
        stage('Build Docker Images') {
            steps {
                sh 'docker build -t walmart-backend:latest backend/'
                sh 'docker build -t walmart-frontend:latest frontend/'
            }
        }
        stage('Deploy to Kubernetes') {
            steps {
                sh 'kubectl apply -f k8s/'
            }
        }
    }
}
