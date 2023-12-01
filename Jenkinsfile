pipeline {
    agent any

    stages {
        stage('Check Port Availability') {
            steps {
                script {
                    // Check if port 8080 is available
                    def isPortAvailable = isPortFree(8080)

                    if (!isPortAvailable) {
                        echo 'Port 8080 is not available. Terminating the process...'

                        // Find and kill the process using port 8080
                        terminateProcessByPort(8080)
                    } else {
                        echo 'Port 8080 is available. Proceeding with the pipeline...'
                    }
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Building...'
                // Your build steps go here
            }
        }

        stage('Test') {
            steps {
                echo 'Testing...'
                // Your test steps go here
            }
        }

        stage('Deploy') {
            steps {
                echo 'Deploying...'
                // Your deploy steps go here
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

    // Function to check if a port is free
    def isPortFree(port) {
        return !("netstat -an | find \"LISTENING\" | find \"${port}\"".execute().text)
    }

    // Function to terminate a process using a specific port
    def terminateProcessByPort(port) {
        script {
            def pid = "netstat -ano | find \"LISTENING\" | find \"${port}\"".execute().text.tokenize()[4]
            if (pid) {
                echo "Terminating process with PID ${pid} using port ${port}..."
                // Use 'taskkill' to forcefully terminate the process
                bat "taskkill /F /PID ${pid}"
            } else {
                echo "No process found using port ${port}."
            }
        }
    }
}
