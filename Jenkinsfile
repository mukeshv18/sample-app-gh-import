
pipeline {
  agent any

  // Optionally declare tools configured in Jenkins Global Tool Configuration
  tools {
    jdk 'JDK11'        // Name as configured in Jenkins (Manage Jenkins → Global Tool Configuration)
    maven 'Maven3'     // Name as configured in Jenkins
  }

  environment {
    // Optional flags to speed up Maven and make builds reproducible
    MAVEN_OPTS = '-Xmx1024m'
    // Use local repository inside workspace to avoid shared cache issues
    MAVEN_USER_HOME = "${WORKSPACE}/.m2"
  }

  stages {
    stage('Checkout') {
      steps {
        // Uses the SCM configured for the Jenkins job or multibranch pipeline
        checkout scm
        // Or explicitly:
        // git branch: 'main', url: 'https://github.com/your-org/your-repo.git', credentialsId: 'your-creds-id'
      }
    }

    stage('Build') {
      steps {
        // If you defined Maven in tools{} you can just call 'mvn'
        sh 'mvn --version'
        sh 'mvn clean install -B -U'
      }
    }

    // Optional: run tests separately or publish reports
    stage('Unit Tests') {
      when { expression { fileExists('pom.xml') } }
      steps {
        sh 'mvn test -B'
      }
      post {
        always {
          // If you generate surefire reports
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
      // Keep workspace clean between runs
      cleanWs()
    }
  }
}
``
