pipeline {
  agent any

 tools {
        dockerTool 'Docker'
    }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    
    stage('Dockerfile is Run!') {
      steps {
        script {
          sh 'docker-compose up -d'
        }
      }
    }
  }
}
