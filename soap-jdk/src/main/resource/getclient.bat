echo ���ڻ�ȡwsdl ������class
wsimport http://localhost:8080/ws/soap/hello?wsdl

echo ���ڴ��client.jar�ļ�
jar cvf client.jar *

echo ����ɾ����һ���Ķ����ļ�
rmdir /s/q me