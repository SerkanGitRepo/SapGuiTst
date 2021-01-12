pipeline{
	environment{
		JAVA_TOOL_OPTIONS='-Duser.home=/usr/share/maven'
	}
	agent any
	
	stages{
		stage('build'){
			steps{
				sh 'mvn verify'
			}
		}
	}
}