pipeline {
  agent any

 tools {
        docker 'Docker'
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
