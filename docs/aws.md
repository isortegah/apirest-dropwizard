##AWS
  
-----
Se implementan dos formas para la obtencion de las credenciales de `aws`, por el archivo 
`credentials`y por variables de ambiente.

El archivo `credentials` debe estar ubicado en el `HOME` del usuario:

 ```bash
~/.aws/credentials

~/ cat .aws/credentials

[default]
aws_secret_access_key=aaaa
aws_access_key_id=zzzz
```

Para la implementación de las credienciales verificar en el resultado del siguiente [Compare en gitHub](https://github.com/isortegah/apirest-full/compare/4d3a91486f242db456f063ba5c7bbaa80419d209...fa5addc0fb57a98174f44edbeae5235af2657274) los cambios a los siguientes archivos:

> `rest/src/main/java/com/isortegah/rest/ApiRestService.java`
> `rest/src/main/java/com/isortegah/rest/RestConfiguration.java`
> `aws/pom.xm`
> `aws/src/main/java/com/isortegah/aws/AwsCredentials.java`
> `aws/src/main/java/com/isortegah/aws/AwsS3.java`
> `dtos/src/main/java/com/isortegah/dtos/configAws/ConfigAws.java`

Para el caso de las credenciales vía variables de ambiente el proceso es el siguiente:

* Exportar las variables:
```bash
export AWS_ACCESS_KEY_ID="xyz"
export AWS_SECRET_ACCESS_KEY="aaa"
```
En MacOs y Linux agregarlas en el archivo .bashrc o .bash_profile y recargarlo.
```bash
source .bash_profile
```
Para Windows usar el comando:
```bash
set AWS_ACCESS_KEY_ID="xyz"
set AWS_SECRET_ACCESS_KEY="aaa"
```
Lo anterior para poder ejecutar el comando:
```bash
java -jar rest/target/rest-0.1-SNAPSHOT.jar server config.yml
```
* En el archivo `config.yml`cambiar el valor `File` por `Environment`.
```yaml
aws: 
  credentialProvider: Environment
``` 

Para la implementación de las credenciales vía variables de ambiente ver la siguiente [Comparación en github](https://github.com/isortegah/apirest-full/compare/8fc54b34f077b1752faa978dee0b07db91f0834d...cbd8c5ebd75e82e147f950b187a13b05be380727), los archivos a revisar son:

> `aws/src/main/java/com/isortegah/aws/AwsCredentials.java`

**Ejecución**

Se presentan las siguientes opciones de ejecución de la imagen docker.

* De forma directa:

```bash
docker run -it -p 8080:8080 -e PORT=8080 -e AWS_ACCESS_KEY_ID=xyzqwd -e AWS_SECRET_ACCESS_KEY=aaa fba5ce1e06db
```
* Vía docker-compose:  
    * Crear archivo `docker-compose.yml`
```yml
version: '3'
services:
  web:
    image: api-rest
    env_file: 
      - ./.env
    environment: 
      - AMBIENTE="DEV"
    ports: 
      - "8080:8080"
```

* 
    * Crear archivo `.env` donde registraremos las variables de ambiente

```bash
AWS_ACCESS_KEY_ID=xyz
AWS_SECRET_ACCESS_KEY=aaa
```

**Nota:** Lo recomendable por practico y seguro, cuando ejecutemos en local, es usar el docker-compose, en el caso que estemos desarrollando podemos utilizar el archivo de credenciales.