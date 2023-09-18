


<h1 align="center"> Generador de Firma  - Merchant Signature</h1>
<p align="center"> <img src="http://www.redsys.es/img/logo.png"/></p>
<p align="center"><img src="  
http://www.redsys.es/img/paygold.png"/></p> 

## Tabla de contenidos:
---

- [Badges](#Badges)
- [Descripción y contexto](#descripción-y-contexto)
- [Guía de usuario](#guía-de-usuario)
- [Guía de instalación](#guía-de-instalación)
- [Licencia](#licencia)
- [Limitación de responsabilidades - Solo BID](#limitación-de-responsabilidades)

## Badges
---
![Static Badge](https://img.shields.io/badge/Sig%20%7C%20Gen-Tool-yellow)  ![Static Badge](https://img.shields.io/badge/v1.0.0-Release-blue)


## Descripción y contexto
---
Proyecto que proporciona una api que permite generar la firma del comercio (Merchant Signature) y así poder realizar el pago on-line en la plataforma [Redsys](http://www.redsys.es)

## Guía de usuario
---

Una vez iniciado el servicio se hace una petición de tipo `POST`  a `[path-of-server]/api/v1/auth`
* ejemplo desde postman:
    * ` http://localhost:8080/api/v1/auth`
      ![[Pasted image 20230918172543.png]]
    * Parametros que van en el body selecionar la opcion `raw` tipo `json`
      ![[Pasted image 20230918174030.png]]

  ```
  {
      "DS_MERCHANT_AMOUNT": "45.67",
      "DS_MERCHANT_ORDER": "123123",
      "DS_MERCHANT_MERCHANTCODE": "333333",
      "DS_MERCHANT_CURRENCY": "978",
      "DS_MERCHANT_TRANSACTIONTYPE": "0",
      "DS_MERCHANT_MERCHANTURL": "https://miurl",
      "DS_MERCHANT_TERMINAL": "3",
      "DS_MERCHANT_URLOK": "https://200.html",
      "DS_MERCHANT_URLKO": "https://404.html",
      "DS_MERCHANT_MERCHANTNAME": "MY E-COMMERCE"
  }
  ```

* Se obtiene como respuesta los parámetros codificados en base64
  ![[Pasted image 20230918174211.png]]

* Con estos parámetros se hace una petición de tipo `POST` a la `api` de **Redsys**, ejemplo :
  ![[Pasted image 20230918174445.png]]
    - Nota: revisar en la pagina de [Redsys](http://www.redsys.es) en caso de haber cambios en los parámetros o url de petición.


## Guía de instalación
---

* Crear una carpeta donde se clonara la app, ej:
    *  `mkdir miapp`
    * `cd miapp`
    * `git clone https://github.com/monomana/redsys.git`

* Para poder ejecutar la app se debe crear las variables de entorno:
    * `SHA_256_KEY` - clave que se obtiene en el panel de administración de usuario [Redsys](http://www.redsys.es)
    * `END_POINT_PAYMENT` - para personalizar el end point de la api por ej; `"/api/v1/auth"`
      ejemplo linux `export END_POINT_PAYMENT= /api/v1/auth`
    * `SERVER_PORT` (opcional) por defecto escucha en el puerto `8080`.
    * Ejecutar	`mvn clean`, `mvn install` y  `mvn package`
    * en la carpeta `/dist` se encuentra nuestro archivo `.jar` para distribuir.
        * `cd dist`
    * Ejecutar el comando `java -jar redsys-0.0.1-SNAPSHOT.jar`

### Requerimientos
* java versión 17
* maven 4.0


### Dependencias
Descripción de los recursos externos que generan una dependencia para la reutilización de la herramienta digital (librerías, frameworks, acceso a bases de datos y licencias de cada recurso). Es una buena práctica describir las últimas versiones en las que ha sido probada la herramienta digital.

    Puedes usar este estilo de letra diferenciar los comandos de instalación.

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

```
<dependency>
	<groupId>org.json</groupId>
	<artifactId>json</artifactId>
	<version>20220924</version>
</dependency>
```

```
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

```
<dependency>
<groupId>javax.xml.bind</groupId>
	<artifactId>jaxb-api</artifactId>
	<version>2.3.0</version>
</dependency>
```

```
<dependency>
	<groupId>org.apache.pdfbox</groupId>
	<artifactId>pdfbox</artifactId>
	<version>2.0.29</version>
</dependency>
```

## Tecnologías
---
* Spring Boot version 3.1.1

## Licencia
---

```
MIT License  
  
Copyright (c) 2023 Mauricio Javier Agüero Trotta  
  
Por la presente se concede permiso, sin coste alguno, a cualquier persona que obtenga una copia  
de este software y archivos de documentación asociados (el "Software"), para tratar  
en el Software sin restricción, incluidos, entre otros, los derechos  
utilizar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender  
copias del Software y para permitir a las personas a quienes el Software es  
proporcionado para ello, sujeto a las siguientes condiciones:  
  
El aviso de derechos de autor anterior y este aviso de permiso se incluirán en todos  
copias o partes sustanciales del Software.  
  
EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O  
IMPLÍCITAS, INCLUYENDO PERO NO LIMITADO A LAS GARANTÍAS DE COMERCIABILIDAD,  
IDONEIDAD PARA UN FIN PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO EL  
LOS AUTORES O TITULARES DE DERECHOS DE AUTOR SERÁN RESPONSABLES DE CUALQUIER RECLAMACIÓN, DAÑOS U OTROS  
RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE OTRA MANERA, QUE SURJA DE,  
FUERA DE O EN RELACIÓN CON EL SOFTWARE O EL USO U OTRAS NEGOCIOS EN EL  
SOFTWARE.
```

## Limitación de responsabilidades

No me hago responsable, bajo circunstancia alguna, de daño ni indemnización, moral o patrimonial; directo o indirecto; accesorio o especial; o por vía de consecuencia, previsto o imprevisto, que pudiese surgir:

i. Bajo cualquier teoría de responsabilidad, ya sea por contrato, infracción de derechos de propiedad intelectual, negligencia o bajo cualquier otra teoría; y/o

ii. A raíz del uso de la Herramienta Digital, incluyendo, pero sin limitación de potenciales defectos en la Herramienta Digital, o la pérdida o inexactitud de los datos de cualquier tipo. Lo anterior incluye los gastos o daños asociados a fallas de comunicación y/o fallas de funcionamiento de computadoras, vinculados con la utilización de la Herramienta Digital.

