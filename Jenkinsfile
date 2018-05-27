pipeline {
    environment {
        BUILD_SCRIPTS_GIT = "https://github.com/AlekseySamoylov/learn-security.git"
        BUILD_HOME = '/var/lib/jenkins/workspace'
    }
    agent any
    stages {
        stage('Git checkout') {
            steps {
                sh 'git ${env.'
                withMaven(maven: 'maven_3_5_3') {
                    sh 'mvn clean compile'
                }
            }
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
        stage('Package Stage') {
            steps {
                withMaven(maven: 'maven_3_5_3') {
                    sh 'mvn package'
                }
            }
        }

//        stage ('dockerization') {
//            steps {
//                sh '''
//        docker build -t alekseysamoylov/learn-security .
//        '''
//            }
//        }

//        stage('Build Image') {
//            steps {
//                script {
//                    def app = docker.build('alekseysamoylov/learn-security', '--no-cache=true dockerbuild')
//
//                }
//            }
//        }

//        stage('Test Image') {
//            /* Ideally, we would run a test framework against our image.
//             * For this example, we're using a Volkswagen-type approach ;-) */
//
//            app.inside {
//                sh 'echo "Tests passed"'
//            }
//        }
//
//        stage('Push Image') {
//            /* Finally, we'll push the image with two tags:
//             * First, the incremental build number from Jenkins
//             * Second, the 'latest' tag.
//             * Pushing multiple tags is cheap, as all the layers are reused. */
//            docker.withRegistry('https://registry.hub.docker.com', 'docker-hub-credentials') {
//                app.push("${env.BUILD_NUMBER}")
//                app.push("latest")
//            }
//        }
    }
}
