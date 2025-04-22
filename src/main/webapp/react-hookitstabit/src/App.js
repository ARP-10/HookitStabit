import React, { useEffect, useState } from "react";
import "./App.css";

function App() {
    // Estado para almacenar las categorías
    const [categorias, setCategorias] = useState([]);

    // Realiza la llamada al servlet cuando el componente se monta
    useEffect(() => {
        fetch("http://localhost:8080/HookitStabit/api/categorias") // Cambia HookitStabit según el contexto de tu aplicación
            .then((response) => {
                if (!response.ok) {
                    throw new Error("Error al obtener las categorías");
                }
                return response.json();
            })
            .then((data) => setCategorias(data)) // Actualiza el estado con los datos obtenidos
            .catch((error) => console.error("Error:", error));
    }, []);

    return (
        <div className="App">
            <header className="App-header">
                <h1>Lista de Categorías</h1>
                {categorias.length > 0 ? (
                    <ul>
                        {categorias.map((categoria) => (
                            <li key={categoria.id}>
                                {categoria.nombre}
                            </li>
                        ))}
                    </ul>
                ) : (
                    <p>Cargando categorías...</p>
                )}
            </header>
        </div>
    );
}

export default App;
