pipeline {
  agent any

  parameters {
    booleanParam(name: 'BUILD', defaultValue: true, discription: 'Checkout 받은 소스를 빌드합니다')
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
          param.BUILD == true
        }
      }

      steps{
        echo 'mvn claen package'
        sh 'mvn -version'
      }
    }
  }
}
