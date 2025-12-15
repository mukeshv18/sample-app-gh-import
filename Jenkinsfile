
pipeline {
  agent any

  tools {
    jdk 'JDK11'        // Must exist in Manage Jenkins → Global Tool Configuration
    maven 'Maven3'     // Must exist in Manage Jenkins → Global Tool Configuration
  }

  environment {
    MAVEN_OPTS = '-Xmx1024m'
    MAVEN_USER_HOME = "${WORKSPACE}/.m2"
  }

  stages {
    stage('Checkout') {
      steps {
        // Uses SCM configured on the job; for Multibranch this is automatic
        checkout scm
        // Or explicitly:
        // git branch: 'main', url: 'https://github.com/your-org/your-repo.git', credentialsId: 'your-creds-id'
      }
    }

    stage('Build') {
      steps {
        sh 'mvn --version'
        sh 'mvn clean install -B -U'
      }
    }

    stage('Unit Tests') {
      when { expression { fileExists('pom.xml') } }
      steps {
        sh 'mvn test -B'
      }
      post {
        always {
          junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
        }
      }
    }
  }

  post {
    success {
      echo '✅ Build succeeded!'
      archiveArtifacts artifacts: '**/target/*.jar', onlyIfSuccessful: true
    }
    failure {
      echo '❌ Build failed.'
    }
    always {
      cleanWs()
    }
  }
}

