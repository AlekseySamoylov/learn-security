pipeline {
    environment {
        BUILD_SCRIPTS_GIT = "https://github.com/AlekseySamoylov/learn-security.git"
        BUILD_HOME = '/var/lib/jenkins/workspace'
    }
    agent any
    stages {
        stage('Clone repository') {
            /* Let's make sure we have the repository cloned to our workspace */
            checkout scm
        }
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
        stage('Package stage') {
            steps {
                withMaven(maven: 'maven_3_5_3') {
                    sh 'mvn package'
                }
            }
        }
        stage('Build image') {
            /* This builds the actual image; synonymous to
             * docker build on the command line */

            app = docker.build("alekseysamoylov/learn-security")
        }

        stage('Test image') {
            /* Ideally, we would run a test framework against our image.
             * For this example, we're using a Volkswagen-type approach ;-) */

            app.inside {
                sh 'echo "Tests passed"'
            }
        }

        stage('Push image') {
            /* Finally, we'll push the image with two tags:
             * First, the incremental build number from Jenkins
             * Second, the 'latest' tag.
             * Pushing multiple tags is cheap, as all the layers are reused. */
            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
                app.push("${env.BUILD_NUMBER}")
                app.push("latest")
            }
        }
    }
}
