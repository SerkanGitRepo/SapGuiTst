pipeline{
	environment{
		JAVA_TOOL_OPTIONS='-Duser.home=/var/maven'
	}
	agent{
		docker{
			image 'maven:3.6.0-jdk-13'
			args '-v /tmp/maven:/var/maven/.m2 -e MAVEN_CONFIG=/var/maven/.m2'
		}
	}
	
	stages{
		stage('Init'){
			steps{
				sh 'mvn install:install-file -Dfile=Jacobjacob-1.20-x86.dll -DgroupId=com.jacob -DartifactId=jacob  -Dversion=1.20 -Dpackaging=dll -DgeneratePom=true'
			}
		}
		stage('build'){
			steps{
				sh 'maven verify'
			}
		}
	}
}