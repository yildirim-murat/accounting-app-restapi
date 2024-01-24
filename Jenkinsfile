pipeline {
  
  agent any
  
  stages {
    
    stage("Build") {
      steps{
        echo 'build app'
        sh 'mvn clean package -Pprod'
      }
    }
    
    stage("Test") {
      steps{
          echo 'testing the application codes'
      }
    }

    stage("Deploy") {
      steps{
          echo 'deploying the app'
      }
    }
  }
}
