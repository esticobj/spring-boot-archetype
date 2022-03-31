# spring-boot-archetype
## 使用方法
1.在本项目下执行

```shell script
mvn org.apache.maven.plugins:maven-archetype-plugin:3.1.2:create-from-project
cd target/generated-sources/archetype
mvn clean install
```
2.新开窗口，执行
```shell script
mvn -DinteractiveMode=false -DgroupId=org.example -DartifactId=test0331-2 -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=org.example.archetypes -DarchetypeArtifactId=spring-boot-template-archetype -DarchetypeVersion=1.0-SNAPSHOT org.apache.maven.plugins:maven-archetype-plugin:RELEASE:generate
```