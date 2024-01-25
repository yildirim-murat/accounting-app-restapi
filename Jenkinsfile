pipeline {
  agent any

  tools {
    maven 'MAVEN'
    dockerTool 'DOCKER'
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
            echo 'Docker daemon access test successful.'
          } else {
            echo 'Unable to access Docker daemon. Make sure Docker is installed and the user has the necessary permissions.'
          }
        }
      }
    }
    // Diğer aşamaları buraya ekleyin
  }
}
