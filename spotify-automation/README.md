# Automatización Spotify Web - Serenity BDD, Selenium, Cucumber

## 1. Instrucciones de instalación y ejecución

### 1.1 Requisitos previos

- JDK 11 instalado (por ejemplo 11.0.23).
- Gradle 7+ o uso del wrapper `./gradlew`.
- Navegador Google Chrome instalado.
- Acceso a una cuenta válida de Spotify (gratuita o de prueba).

### 1.2 Clonar el proyecto

```bash
git clone https://github.com/AndresGallego08/spotify-ui-automation.git
cd spotify-automation
```

### 1.3 Configuración de credenciales

Las credenciales se gestionan mediante propiedades de Serenity.

Por defecto se encuentran en `serenity.properties`:

```properties
spotify.user.email=spotify.castor.ag@gmail.com
spotify.user.password=Castor2025*
```

Se recomienda sobrescribirlas al ejecutar las pruebas:

```bash
./gradlew clean test aggregate \
  -Dspotify.user.email=tu_correo@dominio.com \
  -Dspotify.user.password=tu_clave_real
```

---

## 2. Dependencias necesarias

Las dependencias principales se definen en `build.gradle`:

- Java 11
- Serenity BDD  
  - `serenity-core`  
  - `serenity-junit`  
  - `serenity-cucumber`
- Selenium WebDriver (incluido a través de Serenity).
- Cucumber JVM para la definición de escenarios en Gherkin.
- JUnit 4 como framework de ejecución.
- Gestión automática de drivers mediante la propiedad `webdriver.autodownload=true`.

---

## 3. Comandos para ejecutar las pruebas y generar reportes

Ejecutar todos los escenarios y generar el reporte de Serenity:

```bash
./gradlew clean test aggregate
```

El comando realiza:

- Compilación del proyecto.
- Ejecución de las pruebas automatizadas.
- Generación del reporte HTML consolidado de Serenity en `target/site/serenity`.

También se pueden ejecutar solo pruebas con determinados tags, por ejemplo:

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@smoke"
```

---

## 4. Ejemplo de interpretación del reporte de resultados

Una vez finalizada la ejecución, abrir el archivo:

```text
target/site/serenity/index.html
```

En el reporte se visualiza:

- Resumen general de la ejecución: cantidad de tests ejecutados, pasados y fallados.
- Listado de features y escenarios con su estado (success, failure, pending).
- Detalle por escenario, incluyendo:
  - Pasos ejecutados con su resultado.
  - Capturas de pantalla en los pasos marcados según la configuración.
  - Tiempos de ejecución.

Este reporte permite:

- Ver rápidamente qué escenarios fallaron y en qué paso.
- Identificar tiempos de respuesta y posibles problemas de estabilidad.
- Contar con evidencia clara de la ejecución para el equipo.

---

## 5. Organización del proyecto y buenas prácticas

- **Page Object Model (POM)**  
  - `LoginPage`, `HomePage` y `BrowsePage` encapsulan la interacción con la interfaz de usuario.
- **Scripts modulares y reutilizables**  
  - Steps separados por funcionalidad (`LoginSteps`, `SearchSteps`, `BrowsePlaylistsSteps`).
  - Precondiciones reutilizadas mediante steps compartidos y `Background` cuando aplica.
- **Uso de esperas explícitas**  
  - Uso de `waitFor()` y `waitUntilVisible()` en los Page Objects en lugar de esperas fijas.
- **Estructura estándar Serenity-Cucumber**  
  - Features bajo `src/test/resources/features`.
  - Steps y Pages bajo `src/test/java`.
  - Runner central `SpotifyTestSuite.java`.

