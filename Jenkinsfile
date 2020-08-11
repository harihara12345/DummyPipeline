pipeline
{
    agent any
    stages{
        stage('Compile Cucumber Project')
        {
            steps
            {
                 withMaven(maven : 'maven_3_6_3')
            {
             sh 'mvn clean compile'   
            }
            }
            
        }
        stage('Execute Cucumber Project')
        {
            steps
            {
                 withMaven(maven : 'maven_3_6_3')
            {
             sh 'mvn test'   
            }
            } 
        }
    }
}
