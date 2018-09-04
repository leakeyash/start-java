```
mvn archetype:generate -DgroupId=com.startjava -DartifactId=j2se -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
```

archetype:generate 表示创建个项目  
-DgroupId 项目包名: com.startjava  
-DartifactId 项目名称: j2se  
-DarchetypeArtifactId 项目类型: maven-archetype-quickstart  
-DinteractiveMode:false 表示前面参数都给了，就不用一个一个地输入了

```
mvn package
```
package做了很多事情，编译，测试，打包，最后生成了一个j2se-1.0-SNAPSHOT.jar包，里面放了APP这个类

```
java -cp target/j2se-1.0-SNAPSHOT.jar com.startjava.App
```