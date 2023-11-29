pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                // Use 'bat' for Windows commands
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                // Use 'bat' for Windows commands
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Use 'bat' for Windows commands
                bat 'mvn spring-boot:run'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
        }
        failure {
            echo 'Pipeline failed. Check the console output for details.'
        }
    }
}
