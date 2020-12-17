# Login

## Modificaciones

Se ha modificado en la clase SplashActivity la condicion para acceder a los distintos Activities; en el video sugieren que sea si los campos son no vacios; no creo que este de mas validarlo nuevamente por si hay alguna modificacion como:

    public static String getEmailPreferences(SharedPreferences preferences) {
        return preferences.getString("EMAIL", "No se encuentra el Email");
    }

Se han trasladado las validaciones a la clase Utils para reutilizarlos
