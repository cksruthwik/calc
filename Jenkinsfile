pipeline {
    agent any

    stages {
        stage('Kill Process') {
            steps {
                script {
                    // Get the PID from the environment variable
                    def pid = env.SPRING_BOOT_PID

                    if (pid) {
                        // Kill the process
                        sh "kill -15 ${pid}"
                    } else {
                        echo "No PID found. The process might not be running."
                    }
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
