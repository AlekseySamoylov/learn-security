pipeline {
    environment {
        BUILD_SCRIPTS_GIT = "https://github.com/AlekseySamoylov/learn-security.git"
        BUILD_SCRIPTS = 'mypipeline'
        BUILD_HOME = '/var/lib/jenkins/workspace'
    }
    agent any
    stages {
        stage('Compile Stage') {
            steps {
                withMaven(maven: 'maven_3_5_3') {
                    sh 'mvn clean compile'
                }
            }
        }
        stage('Testing Stage') {
            steps {
                withMaven(maven: 'maven_3_5_3') {
                    sh 'mvn test'
                }
            }
        }


        stage('Deployment stage') {
            steps {
                withMaven(maven: 'maven_3_5_3') {
                    sh 'mvn package'
                }
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
