pipeline {
  agent any

  environment {
        DOCKER_COMPOSE = tool 'Docker'
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
          sh "${DOCKER_COMPOSE} up -d"
        }
      }
    }   
  } 
}
