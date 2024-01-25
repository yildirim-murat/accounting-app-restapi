pipeline {
  
  // agent any

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
// dockerImageName = "spring-app:latest"

  agent any
  
  environment {
      PATH = "${tool 'MAVEN'}/bin:${env.PATH}"
  }

  stage('Check Maven') {
            steps {
                script {
                    // Maven'ın yüklü olup olmadığını kontrol et
                    def mavenCheck = sh(script: 'mvn --version', returnStatus: true)
                    if (mavenCheck == 0) {
                        echo 'Maven is installed.'
                    } else {
                        error 'Maven is not installed.'
                    }
                }
            }
    

// stages {
//     stage('Checkout') {
//         steps {
//             checkout scm
//         }
//     }
//     stage('Build') {
//         steps {
//             sh 'mvn clean package'
//         }
//     }
//     stage('Dockerize') {
//         steps {
//             script {
//                 docker.build("spring-app:latest")
//             }
//         }
//     }
//     stage('Deploy') {
//         steps {
//             script {
//                 docker.withRegistry('https://192.168.1.40:8081', 'docker-registry-credentials') {
//                     docker.image("spring-app:latest").push()
//                 }
//               }
//             }
//           }
//         }
  
}
