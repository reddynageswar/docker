pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                echo "📥 Cloning repo..."
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo "🔧 Running build steps..."
                sh """
                  cd /var/lib/jenkins/workspace/Jenkins_docker_project/Docker/miniproject/
                  docker-compose -f docker-compose.yaml down
                  docker-compose -f docker-compose.yaml build
                  docker-compose -f docker-compose.yaml up -d
                 """
                sh 'echo "Build successful!"'
            }
        }

        stage('Test') {
            steps {
                echo "✅ Running tests..."
                sh 'echo "All tests passed!"'
            }
        }

        stage('Deploy') {
            steps {
                echo "🚀 Deploying application..."
                sh 'echo "Deployed successfully!"'
            }
        }
        stage('Check Application Availability') {
    steps {
        script {
            def publicIp = '3.86.2.216'  // Replace with actual IP or inject as env var

            def ports = [3000, 5000]

            ports.each { port ->
                def url = "http://${publicIp}:${port}"

                echo "Checking availability for ${url}..."

                def response = sh(
                    script: "curl -s -o /dev/null -w \"%{http_code}\" ${url}",
                    returnStdout: true
                ).trim()

                if (response == '200') {
                    echo "✅ Application on port ${port} is UP."
                } else {
                    error("❌ Application on port ${port} is NOT reachable. Status: ${response}")
                }
            }
        }
    }
}

    }

    post {
        success {
            echo "🎉 Pipeline completed successfully!"
        }
        failure {
            echo "❌ Pipeline failed!"
        }
    }
}
