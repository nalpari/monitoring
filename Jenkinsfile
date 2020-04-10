def ROLLBACK_PROCESS = false
def DEPLOY_PATH = "/root/apps/"

pipeline {
  agent any

  environment {
	M2_HOME = '/root/lib/apache-maven-3.6.3/bin'
  }

  parameters {
	choice(name: 'CHOICE', choices: ['전체', '01&02', '03&04', '01', '02', '03', '04'], description: '배포할 인스턴스를 선택하세요.')
	booleanParam(name: 'STATIC', defaultValue: false, description: 'static 리소스도 같이 배포 합니다.')
	booleanParam(name: 'RESTART', defaultValue: true, description: '배포후 어플리케이션을 재시작합니다.')
	booleanParam(name: 'REVISION', defaultValue: false, description: '특정 Revision으로 배포합니다.')
	string(name: 'REVISION_NUMBER', defaultValue: '', description: '특정 Revision 번호를 입력 하세요.(생략가능)')
  }

  stages {
	stage('Initialize') {
	  steps {
		script {
		  echo '준비작업을 진행합니다.'
		  sh 'pwd'
		  sh 'ls -al'
		}
	  }
	}

	stage('Build Normal') {
	  when {
		expression {
		  ROLLBACK_PROCESS == false && params.ROLLBACK == false
		}
	  }

	  steps {
		script {
            echo '어플리케이션 빌드를 진행합니다.'
            try {
                //sh '/root/lib/apache-maven-3.6.3/bin/mvn -version'
                sh '/root/lib/apache-maven-3.6.3/bin/mvn clean package'
            } catch (e) {
                ROLLBACK_PROCESS = true
            }
		}
	  }
	}

	stage('Build Abnormal') {
      when {
        expression {
          ROLLBACK_PROCESS == false && params.ROLLBACK == true
        }
      }

      steps {
        script {
            echo '특정 Revision으로 어플리케이션을 빌드합니다.'
            try {
                //sh '/root/lib/apache-maven-3.6.3/bin/mvn -version'
                sh 'git checkout' + params.REVISION_NUMBER
                sh '/root/lib/apache-maven-3.6.3/bin/mvn clean package'
            } catch (e) {
                ROLLBACK_PROCESS = true
            }
        }
      }

      post {
          success {
              sh 'git checkout master'
          }
      }
    }

	stage('Deploy') {
		when {
			expression {
				ROLLBACK_PROCESS == false
			}
		}

		steps {
			script {
				echo '어플리케이션 배포를 진행합니다.'
				try {
					sh 'cp -R target/monitoring*.jar ' + DEPLOY_PATH + "monitoring.jar"
				} catch(e) {
					ROLLBACK_PROCESS = true
				}
			}
		}
	}

	stage('Rollback') {
		when {
			expression {
				ROLLBACK_PROCESS == true
			}
		}

		steps {
			script {
				echo '어플리케이션을 롤백합니다.'
				sh 'ls -al'
			}
		}
	}

	stage('Restart') {
		when {
			expression {
				params.RESTART == true
			}
		}

		steps {
			script {
				echo '어플리케이션을 재시작합니다.'
				sh '/root/command/monitoring.sh stop'
				sh 'sleep 5'
				sh '/root/command/monitoring.sh start'
			}
		}
	}
  }
}
