src/main/webapp/
│── index.html        # Página principal
│── static/           # Archivos estáticos generados por React
│── WEB-INF/          # Configuración de Tomcat
│── frontend/         # Aquí está tu código de React
│   ├── src/         # Código fuente de React
│   │   ├── components/   # Componentes reutilizables (Botones, Cards, Formularios)
│   │   ├── pages/        # Vistas completas (Home, Login, Dashboard)
│   │   ├── services/     # Llamadas a la API (conexión con el backend)
│   │   ├── context/      # Estado global (React Context, Redux si es necesario)
│   │   ├── hooks/        # Custom hooks para lógica reutilizable
│   │   ├── styles/       # Archivos CSS o estilos con Tailwind/SASS
│   │   ├── App.js        # Componente raíz de la aplicación
│   │   ├── index.js      # Entrada principal de React
│   ├── public/         # Contiene imágenes y archivos estáticos no compilados
│   ├── package.json    # Dependencias y configuración de React
