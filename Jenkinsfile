pipeline {
    agent any

    stages {
        stage('Gradle build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew clean build'
            }
        }

        stage('Deploy') {
            when { branch 'main' }
            steps {
                sh 'docker build -t seonjiwon-spring .'
                sh 'docker stop seonjiwon-spring || true'
                sh 'docker rm seonjiwon-spring || true'
                sh 'docker run -d --name seonjiwon-spring -p 12225:8080 seonjiwon-spring'
            }
        }

        stage('Dev Log') {
            when { branch 'dev' }
            steps {
                echo 'dev 브랜치 - 빌드만 확인, 배포 스킵'
                echo "Branch: ${env.BRANCH_NAME}"
                echo "Build Number: ${env.BUILD_NUMBER}"
            }
        }
    }
}