### Тестовое задание

#### Сборка осуществляется с помощью Maven
<ul><li>mvn clean package</ul>

#### В указаных папках необходимые war файлы:
<ul>
<li>core/target/core.war
<li>web/target/web.war
</ul>

Для запуска с помощью Tomcat нужно положить оба файла в папку webapps/<br>
Для веб-приложения в данном случае зашиты url'ы, по которым оно получает доступ к основному приложению

Запуск следует осуществлять на localhost::8080<br>
Веб-приложение будет доступно по localhost::8080/web/
