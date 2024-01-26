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
        docker-compose version
        '''
      }
    }

    // stage('Prune Docker Data'){
    //   steps{
    //     sh 'docker system prune -a --volumes -f'
    //   }
    // }

    stage('Start Container'){
      steps{
        // sh 'docker-compose up -d --no-color --wait'
        sh 'docker build -t restapi .'
        sh 'docker run -p 8081:8081 restapi'
        // sh 'docker-compose ps'
      }
    }
  }
  post{
    always{
      // sh 'docker-compose down --remove-orphans -v'
      // sh 'docker-compose ps'
      echo 'Bitti sanki!'
    }
  }
}
