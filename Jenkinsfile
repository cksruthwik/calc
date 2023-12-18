pipeline {
    agent any

    environment {
        REMOTE_SERVER = '52.91.247.8'
        REMOTE_USER = 'ec2-user'
    }

    stages {
        stage('build run and deploy') {
            steps {
                script {
                    // Define your custom commands
                    

                    // Execute the custom commands on the remote server using SSH
                    sshagent(['c759d2d8-d0fc-4d4b-8083-8b2349c7dacc']) {
                        sh "ssh ${REMOTE_USER}@${REMOTE_SERVER} "
                       /* sh "sudo /opt/tomcat/apache-tomcat-9.0.84/bin/shutdown.sh"
                        sh "rm -rf ecommapp2"
                        sh "git clone https://github.com/cksruthwik/ecommapp2.git"
                        sh "cd ecommapp2"
                        sh "mvn clean install"
                        sh "sudo  mv /home/ec2-user/ecommapp2/target/EcommerceApp.war /opt/tomcat/apache-tomcat-9.0.84/webapps/"
                        sh "sudo /opt/tomcat/apache-tomcat-9.0.84/bin/startup.sh"*/
                        

                    }
                }
            }
        }
    }

    post {
        success {
            echo 'successful!'
        }
    }
}
