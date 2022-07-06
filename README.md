<a href="https://www.arkondata.com/">
    <img src="./img/logo.jpg" align="right" height="80">
</a>

# Arkon's Scala Training

Unidades Metrobús y ubicación en Alcaldías

![image](https://github.com/Grupo-Abraxas/arkon-scalatraining/blob/tanuki-main-Training/images/graphqlApi%203.png?raw=true)

## Descripción

Implementación de un servidor web exponiendo una API GraphQL para consultar información de
unidades de Metro-bus de la Ciudad de México en función de su ubicación en la alcaldía


## Herramientas
- [Scala](https://www.scala-lang.org/2020/06/29/one-click-install.html)
- [IntelliJ (IDE)](https://www.jetbrains.com/idea/download/)
- [sbt](https://www.scala-sbt.org/)
- [insomnia](https://insomnia.rest/)




## DOCKER 

Se implementa docker-compose para configurar los contenedores necesarios,
por lo cual para ejecutar el siguiente comando
se requiere ubicarse en la carpeta raíz del proyecto, en donde se encuentra el archivo *docker-compose.yml*

Run 
```
docker-compose up -d
```
![image](https://github.com/Grupo-Abraxas/arkon-scalatraining/blob/tanuki-main-Training/images/docker-compose%20up%20-d.png?raw=true)

### Imagenes
* [postgis/postgis](https://hub.docker.com/search?q=postgis%2Fpostgis)
* [dpage/pgadmin4](https://hub.docker.com/r/dpage/pgadmin4/)
* [sbtscala/scala-sbt:17.0.2_1.6.2_3.1.3](https://hub.docker.com/r/sbtscala/scala-sbt)

## Comandos SBT
Los siguientes comandos se ejecutan dentro del proyecto  en donde se encuentra el archivo buil.sbt
```
// Run a specific test
sbt run
```
![image](https://github.com/Grupo-Abraxas/arkon-scalatraining/blob/tanuki-main-Training/images/sbt%20run.png?raw=true)


Con este último comando se despliega el servicio WEB
## Api GraphQL EndPoint
localhost:8080/graphql

![image](https://github.com/Grupo-Abraxas/arkon-scalatraining/blob/tanuki-main-Training/images/graphqlApi.png?raw=true)
