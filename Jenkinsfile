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
        '''
      }
    }

    stage('Start Container'){
      steps{
        sh 'docker build -t restapi .'
        sh 'docker run -d -p 8081:8080 restapi'
      }
    }
  }
  post{
    always{
      echo 'İşlem bitti'
    }
  }
}
