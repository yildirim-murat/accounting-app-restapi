pipeline {
  agent any

  tools {
    maven 'Maven'
    dockerTool 'Docker'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Check Docker Daemon Access and Maven Installed') {
      steps {
        script {
          def mavenCheck = sh(script: 'mvn --version',returnStatus: true)
          def dockerVersion = sh(script: 'docker --version', returnStatus: true)
          if (dockerVersion == 0 && mavenCheck == 0) {
            echo 'Docker daemon access successful and maven is installed...'
          } else {
            error 'ERROR: Unable to access Docker daemon or maven is not installed!'
          }
        }
      }
    }

    stage('Dockerfile is Run!') {
      steps {
        sh 'docker-compose up -d'
      }
    }   
  }
}
