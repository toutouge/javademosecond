# Docker image for springboot file run
# VERSION 0.0.1
# Author: toutou
# 基础镜像使用java
FROM java:8
# VOLUME 指定了临时文件目录为/tmp。
# 其效果是在主机 /var/lib/docker 目录下创建了一个临时文件，并链接到容器的/tmp
# VOLUME /tmp
# 将jar包添加到容器中并更名为app.jar
ADD hellolock-0.0.1-SNAPSHOT.jar app.jar
# 运行jar包
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]
###声明启动端口号
#EXPOSE 8301