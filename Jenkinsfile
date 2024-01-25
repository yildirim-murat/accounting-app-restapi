pipeline {
  agent any

  tools {
    maven 'MAVEN'
  }

  stages {
    stage("Test Maven") {
      steps{
        script {
          echo 'Test Maven is Run'
          def mavenCheck = sh (script:'mvn --version', returnStatus: true)
          if (mavenCheck == 0) {
            info 'Maven is installed.'
          } else {
            echo 'Maven is not installed.'
         }
        }
        echo 'Test Maven Step Ended'
      }
    }


  }
}
