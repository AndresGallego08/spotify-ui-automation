# language: es

@search @smoke
Característica: Búsqueda de artistas en Spotify Web
  Como usuario
  Quiero buscar un artista sin necesidad de iniciar sesión
  Para validar que la barra de búsqueda funciona correctamente

  Escenario: Búsqueda de un artista existente
    Dado que estoy en la página principal de Spotify Web
    Cuando busco el término "Coldplay "
    Entonces debería visualizar resultados relacionados con "Coldplay"
