echo 正在获取wsdl 并生成class
wsimport http://localhost:8080/ws/soap/hello?wsdl

echo 正在打包client.jar文件
jar cvf client.jar *

echo 正在删除第一步的多余文件
rmdir /s/q me