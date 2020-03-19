pipeline {
  agent any

  parameters {
    booleanParam(name: 'BUILD', defaultValue: true, description: 'Checkout 받은 소스를 빌드합니다')
  }

  stages {
    stage('Initialize') {
      steps {
        script {
          echo 'Initialize'
          sh 'pwd'
        }
      }
    }

    stage('Build') {
      when {
        expression {
          params.BUILD == true
        }
      }

      steps {
        echo 'mvn claen package'
        sh 'mvn -version'
      }
    }
  }
}
