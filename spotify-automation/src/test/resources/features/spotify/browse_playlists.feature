#language: es

Característica: Navegación a playlists populares

  Como usuario logueado en Spotify Web
  Quiero navegar a las playlists populares
  Para descubrir música nueva

  Antecedentes:
    Dado que estoy en la página de login de Spotify Web
    Cuando ingreso mis credenciales válidas

  @playlists @smoke
  Escenario: Ver Top 50 Global en Top listas
    Cuando navego a la sección "Listas seleccionadas"
    Entonces debería visualizar playlists públicas como "Canciones más escuchadas: Global"
