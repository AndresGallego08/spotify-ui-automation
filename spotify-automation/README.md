# 🎵 Automatización Spotify Web – Serenity BDD, Selenium WebDriver y Cucumber

Este proyecto automatiza flujos clave de la aplicación **Spotify Web** utilizando  
**Java + Serenity BDD + Selenium + Cucumber**, siguiendo buenas prácticas de automatización, Page Object Model y estructura estándar de Serenity.

El objetivo principal es validar la autenticación, búsqueda y navegación de playlists dentro de la plataforma.

---

# 📌 1. Tecnologías Utilizadas

- **Java:** 11.0.23 LTS  
- **Gradle:** 7+ (uso del wrapper incluido `./gradlew`)  
- **Serenity BDD** (Core + JUnit + Cucumber)  
- **Selenium WebDriver**  
- **Cucumber (Gherkin)**  
- **Gestión automática de drivers** con `webdriver.autodownload=true`  
- Ejecuciones en:
  - Google Chrome
  - Chrome Headless (para CI)

---

# 📁 2. Estructura del Proyecto

```
spotify-automation/
├── src/
│   ├── main/java/   # (vacío – no se usa en UI Testing)
│   ├── test/
│   │   ├── java/
│   │   │   ├── com.castor.spotify/
│   │   │   │   ├── pages/          # Page Objects: LoginPage, SearchPage, BrowsePlaylistsPage
│   │   │   │   ├── steps/          # Step Definitions por cada funcionalidad
│   │   │   │   ├── runners/        # Runner central con Serenity + Cucumber
│   │   ├── resources/
│   │   │   ├── features/spotify/   # Features en Gherkin
│   │   │   │   ├── login.feature
│   │   │   │   ├── search_music.feature
│   │   │   │   ├── browse_playlists.feature
│   │   │   ├── serenity.properties
├── build.gradle
├── serenity.properties
├── gradlew / gradlew.bat
├── .gitignore
└── README.md
```

---

# 🔐 3. Configuración de Credenciales

El proyecto usa variables en **serenity.properties**:

```properties
spotify.user.email=tu_correo@dominio.com
spotify.user.password=tu_password
webdriver.autodownload=true
```

Puedes sobrescribirlas en ejecución:

```bash
./gradlew clean test aggregate   -Dspotify.user.email=miusuario@correo.com   -Dspotify.user.password=miclave
```

---

# ▶️ 4. Ejecución Local

## 4.1 Desde la terminal

Ejecutar todos los escenarios:

```bash
./gradlew clean test aggregate
```

Ejecutar solo smoke tests:

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@smoke"
```

Ejecutar solo login:

```bash
./gradlew clean test aggregate -Dcucumber.filter.tags="@login"
```

---

## 4.2 Desde IntelliJ IDEA

1. Abrir `SpotifyTestSuite.java` en la carpeta `runners/`
2. Clic derecho → **Run 'SpotifyTestSuite'**

---

## 🖥 4.3 Ejecución en modo headless

Agregar en `serenity.properties`:

```properties
serenity.browser.headless=true
chrome.switches=--no-sandbox,--disable-gpu,--disable-dev-shm-usage,--window-size=1920,1080
```

---

# 📊 5. Reportes de Ejecución

Serenity genera el reporte en:

```
target/site/serenity/index.html
```

Para verlo:

1. Abrir el archivo en un navegador  
2. Podrás visualizar:
   - Resumen de pruebas
   - Escenarios ejecutados
   - Pasos con screenshots
   - Tiempos de ejecución
   - Errores detallados

---

# ☁️ 6. CI/CD – Pipeline GitHub Actions

Este proyecto incluye un pipeline para ejecutar pruebas automáticamente en GitHub Actions.

## 6.1 Ubicación del workflow

```
.github/workflows/run-serenity-tests.yml
```

## 6.2 Workflow utilizado

```yaml
name: Run Serenity Tests

on:
  push:
    branches: [ "main", "master" ]
  pull_request:
    branches: [ "main", "master" ]
  workflow_dispatch:

jobs:
  test:
    runs-on: ubuntu-latest
    timeout-minutes: 60

    steps:
      - name: Checkout Repository
        uses: actions/checkout@v4

      - name: Set up JDK 11
        uses: actions/setup-java@v3
        with:
          distribution: 'temurin'
          java-version: '11'

      - name: Grant execute permissions to Gradle Wrapper
        run: chmod +x ./gradlew

      - name: Run Serenity Tests
        run: ./gradlew clean test aggregate

      - name: Upload Serenity Report
        uses: actions/upload-artifact@v4
        with:
          name: serenity-report
          path: target/site/serenity/
          retention-days: 30
```

---

# 📥 6.3 ¿Cómo ejecutar el workflow manualmente?

1. Ir a **Actions** en el repositorio  
2. Seleccionar el workflow **Run Serenity Tests**  
3. Clic en **Run workflow**  
4. Esperar la ejecución  
5. Descargar el reporte

---

# 📤 6.4 ¿Cómo descargar el reporte desde GitHub Actions?

1. Ir a **Actions**  
2. Abrir la última ejecución  
3. Buscar el job `test`  
4. Abrir **Upload Serenity Report**  
5. Clic en **Download artifact**  
6. Descomprimir  
7. Abrir:

```
index.html
```

---

# 🧱 7. Buenas Prácticas del Proyecto

- Page Object Model (POM) limpio y escalable  
- Steps separados por funcionalidad  
- Uso obligatorio de esperas explícitas (`waitFor`, `waitUntilVisible`)  
- Background utilizado únicamente cuando aplica  
- Features en español, claros y reutilizables  
- Sin datos quemados en el código  
- Locators dinámicos para playlists y búsquedas  
- Código organizado por capas (Pages, Steps, Runner)

---

# 📞 8. Contacto

Para dudas o mejoras, puedes abrir un **Issue** o realizar un **Pull Request** directamente en el repositorio.

---

Gracias por usar este framework ✨
