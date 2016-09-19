# SpringMVC
> Proyecto básico para la implementación de Spring MVC con el servidor de aplicaciones TOMCAT y uso de JDNI para el acceso 
> a la base de datos.

### Dependencias
- spring-beans
- spring-context
- spring-core
- spring-web
- spring-webmvc
- spring-expression
- spring-jdbc
- jstl
- mysql-connector-java


### JSTL
```sh
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
```

### Spring Form
```sh
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
```

### Configuración para el acceso mediante JDNI
```sh
<Resource name="jdbc/spring" auth="Container" type="javax.sql.DataSource"
		maxActive="100" maxIdle="30" maxWait="10000" username="username"
		password="password" driverClassName="com.mysql.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/springbd?serverTimezone=UTC" />
```	
