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

     stage('Docker Prune Operations'){
      steps{
        sh 'docker container stop restapp || true'
        sh 'docker container rm -f restapp || true'
        sh 'docker image rm -f restapi || true'
      }
    }

    stage('Start Container'){
      steps{
        sh 'docker build -t restapi .'
        sh 'docker run -d -p 8081:8080 --name restapp restapi'
      }
    }
  }
  post{
            success {
                echo 'CI/CD pipeline ran successfully!'
            }

            failure {
                echo 'CI/CD pipeline failed!'
            }

            always{
              echo 'CI/CD Pipeline Operations have been discontinued.'
            }
  }
}
