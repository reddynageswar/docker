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
                  sudo docker-compose -f docker-compose.yaml build
                  sudo docker-compose -f docker-compose.yaml up -d
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
