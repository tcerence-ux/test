pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK'
    }

    stages {

        stage('Checkout Code') {
            steps {
                git 'https://github.com/tcerence-ux/test.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Run Selenium Tests') {
            steps {
                bat 'mvn clean test -Dsurefire.suiteXmlFiles=testng.xml'
            }
        }

        stage('Publish Test Results') {
            steps {
                testng reportFilenamePattern: '**/target/surefire-reports/testng-results.xml', showFailedBuilds: true
            }
    }

    post {
        success {
            echo 'Tests passed successfully!'
        }
        failure {
            echo 'Tests failed!'
        }
    }
}
