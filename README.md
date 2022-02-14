# weather
基于 Spring Boot 的天气预报服务

实现简单的天气预报功能，可以根据不同的城市或者城市ID，查询该城市的实时天气情况。

使用的技术
Maven
Spring Boot 
RestTemplate

部署方式使用了阿里云的流水线，做到了CI/CD，做到了云部署，
拉取我在github上的代码，执行pom.xml，打包，并部署
代码在github上,使用deploy.sh的shell脚本部署
github: https://github.com/eyngqin/weather-app

访问方法如下：下面是多个城市天气预报的访问
http://47.104.90.206:8087/cityNames/{cityNames}
这里括号中的城市可以填写多个，以逗号分隔例如
http://47.104.90.206:8087/cityNames/青岛,大连,北京

下面是单个城市的天气预报访问，可以输入城市ID
http://47.104.90.206:8087/cityId/{cityID}
for instance:
http://47.104.90.206:8087/cityId/101280601


