pipeline {
  
  agent any

  def dockerImageName = "spring-app:latest"
  // tools{
  //   maven 'MAVEN'
  // }
  
  // stages {
    
  //   stage("Build") {
  //     steps{
  //       echo 'build app'
  //       sh 'mvn clean package'
  //     }
  //   }
    
  //   stage("Test") {
  //     steps{
  //         echo 'testing the application codes'
  //     }
  //   }

  //   stage("Deploy") {
  //     steps{
  //         echo 'deploying the app'
  //     }
  //   }
  // }

stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                sh './mvnw clean package'
            }
        }
        stage('Dockerize') {
            steps {
                script {
                    docker.build(dockerImageName)
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    docker.withRegistry('https://192.168.1.40:8081', 'docker-registry-credentials') {
                        docker.image(dockerImageName).push()
                    }
                }
            }
        }
      }
}
