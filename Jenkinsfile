pipeline{
  agent any

  stages{
    stage('Verify tool'){
      steps{
        sh '''
        docker info
        docker version
        docker compose version
        '''
      }
    }
  }
}
