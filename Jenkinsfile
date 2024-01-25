pipeline{
  agent any
  tools{
    dockerTool 'Docker'
  }
  
  stages{
    stage('Verify tool'){
      steps{
        sh '''
        docker info
        docker version
        docker compose version
        curl --version
        jq --version
        '''
      }
    }
  }
}
