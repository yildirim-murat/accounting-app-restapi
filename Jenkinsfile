pipeline {
  
  agent any
  
  stages {
    
    stage("build") {
      
      steps{
        echo 'building the application'
          script{
            def test = 2 + 2 > 3 ? "ok" :" not ok"
            print test
          }
      }
    }

    stage("test") {
      
      steps{
          echo 'testing the app'
      }
    }

    stage("deploy") {
      
      steps{
          echo 'deploying the app'
      }
    }
  }
}
