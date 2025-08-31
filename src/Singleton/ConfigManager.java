package Singleton;

import java.util.Properties;

// com/ecommerce/config/ConfigManager.java

public class ConfigManager {
    // 1. A instância estática e privada
    private static ConfigManager instance;
    private final Properties properties;

    // 2. O construtor privado para evitar instanciação externa
    private ConfigManager() {
        // Carrega as configurações de um arquivo .properties, por exemplo
        properties = new Properties();
        try {
            // Em um projeto real, carregar de um arquivo
            properties.setProperty("db.url", "jdbc:mysql://localhost:3306/ecommerce");
            properties.setProperty("api.key.payment", "SECRET_KEY_123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 3. O método público estático para obter a instância única
    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
