pipeline {
    agent any

    stages {
        stage('Kill Process') {
            steps {
                script {
                    // Get the PID from the environment variable
                    
                        sh "lsof -t -i :8080 | xargs kill -9
"
                    
                    }
                }
            }
        
        stage('Build') {
            steps {
                echo 'Building...'
                //run 2
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
