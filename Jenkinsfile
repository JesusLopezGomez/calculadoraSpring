pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Obtener el código fuente del repositorio
                git branch: 'main', url: 'https://github.com/JesusLopezGomez/calculadoraSpring.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mkdir -p webapps/CalculadoraSpring'

                sh 'cp -r Jekinsfile build src webapps/CalculadoraSpring/'
            }
        }


        stage('Deploy') {
            steps{
                    echo 'Despligue realizado con éxito'
            }
        }

    }
}
