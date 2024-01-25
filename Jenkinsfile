pipeline {
  agent any

  tools{
    docker 'DOCKER'
  }

  stages {
    stage('Check Docker Daemon Access'){
      steps{
        script{
          def dockerVersion = sh(script: 'docker version',returnStatus: true)
          if (dockerVersion == 0) {
            echo 'Docker daemon access test successful.'
          } else {
            echo 'Unable to access Docker daemon. Make sure Docker is installed and the user has the necessary permissions.'
          }
        }
      }
    }
  }
}
