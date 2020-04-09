pipeline {
  agent any

  environment {
    M2_HOME = '/root/lib/apache-maven-3.6.3/bin'
  }

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
        sh '/root/lib/apache-maven-3.6.3/bin/mvn -version'
      }
    }
  }
}
