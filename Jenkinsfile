pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                echo 'Building...'
                bat 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing...'
                bat 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying...'

                bat 'mvn spring-boot:run'
            }
        }
    }

    post {
        success {
            echo 'Pipeline succeeded!'
            // Any cleanup or additional steps you want to perform on success
        }
        failure {
            echo 'Pipeline failed. Check the console output for details.'
            // Any cleanup or additional steps you want to perform on failure
        }
    }
}
