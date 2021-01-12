pipeline{
	environment{
		JAVA_TOOL_OPTIONS='-Duser.home=/usr/share/maven'
	}
	agent any
	
	stages{
		stage('Init'){
			steps{
				sh 'mvn install:install-file -Dfile=jacob-1.20-x86.dll -DgroupId=com.jacob -DartifactId=jacob  -Dversion=1.20 -Dpackaging=dll -DgeneratePom=true'
			}
		}
		stage('build'){
			steps{
				sh 'mvn verify'
			}
		}
	}
}