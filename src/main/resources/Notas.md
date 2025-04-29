## Respuestas HTTP típicas (para el doPost)

**Usar Thunderclient para comprobar que el servelt funcione bien antes de montar la app completa**

### Conexión exitosa (201 - Created)
response.setStatus(HttpServletResponse.SC_CREATED);

### Solicitud incorrecta (400 - Bad Request)
response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

### No encontrado (404 - Not Found)
response.setStatus(HttpServletResponse.SC_NOT_FOUND);

### Conflict (409 - Conflict)
response.setStatus(HttpServletResponse.SC_CONFLICT);

### Error inerno del servidor (500 - Internal Server Error)
response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

## Usar Jersey para mejorar los servlets

