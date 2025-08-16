pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven3'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/20bci7179/SonarQube.git'
            }
        }
        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }
        stage('Static Code analysis') {
            steps {
                withSonarQubeEnv('MavenSonar') {
                    bat '''
                mvn sonar:sonar ^
                  -Dsonar.projectKey=my-java-app ^
                  -Dsonar.sources=src/main/java ^
                  -Dsonar.java.binaries=target/classes ^
                  -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml
            '''
                }
            }
        }
        stage('Finish') {
            steps {
                echo 'Finished'
            }
        }
    }
}
