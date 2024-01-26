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
                script{
                    sh 'docker stop restapp'
                    sh 'docker rm -f restapp'
                }
              echo 'CI/CD Pipeline Operations have been discontinued.'
            }
  }
}
