#language: es

Característica: Autenticación en Spotify Web
  Como usuario de Spotify Web
  Quiero validar el acceso con diferentes credenciales
  Para asegurar que el proceso de autenticación funciona correctamente

  @login @negativo
  Escenario: Login con email inválido
    Dado que estoy en la página de login de Spotify Web
    Cuando ingreso un correo inválido
    Entonces debería mostrarse un mensaje indicando que el usuario no existe

  @login @negativo
  Escenario: Login con contraseña inválida
    Dado que estoy en la página de login de Spotify Web
    Cuando ingreso un correo válido
    Y avanzo a la pantalla de contraseña
    Y ingreso una contraseña inválida
    Entonces debería mostrarse un mensaje indicando que la contraseña es incorrecta

  @login @positivo
  Escenario: Login exitoso
    Dado que estoy en la página de login de Spotify Web
    Cuando ingreso mis credenciales válidas
    Entonces debería visualizar la página principal de Spotify Web
