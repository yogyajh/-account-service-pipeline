pipeline {
    agent any

    stages {
        stage ('Compile Stage') {

            steps {
                withMaven(maven : '3.8.5') {
                    sh 'mvn install'
                }
            }
        }

        stage ('Testing Stage') {

            steps {
                withMaven(maven : '3.8.5') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Deployment Stage') {
            steps {
                withMaven(maven : '3.8.5') {
                    sh 'mvn deploy'
                }
            }
        }
    }
}