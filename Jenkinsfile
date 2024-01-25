pipeline {
  agent any

  tools {
    maven 'MAVEN'
    docker 'DOCKER'
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage("Check Maven") {
      steps{
        script {
          def mavenCheck = sh (script:'mvn --version', returnStatus: true)
          if (mavenCheck == 0) {
            echo 'Maven is installed.'
          } else {
            error 'Maven is not installed.'
         }
        }
      }
    }
    
    stage('Build') {
      steps {
        sh 'mvn clean package'
      }
    }
    
    stage('Dockerize') {
        steps {
            script {
                docker.build("spring-app:latest")
            }
        }
    }
    stage('Deploy') {
        steps {
            script {
                docker.withRegistry('https://192.168.1.40:8081', 'docker-registry-credentials') {
                    docker.image("spring-app:latest").push()
                }
              }
            }
          }



  }
}
