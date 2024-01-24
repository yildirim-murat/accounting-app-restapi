pipeline {
  
  agent any

  tools{
    maven 'MAVEN'
  }
  
  stages {
    
    stage("Build") {
      steps{
        echo 'build app'
        sh 'mvn clean package'
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
