import java.util.HashMap;

public class AppSettings {
    private static HashMap<String, Integer>settings = new HashMap<>();
    private static AppSettings instance;
    private AppSettings(){}
    public static AppSettings getInstance(){
        if(instance == null){
            instance = new AppSettings();
        }
        return instance;
    }
    public void setSettings(String key, Integer value){
        settings.put(key, value);
    }
    public Integer getSettings(String key){
        return settings.get(key);
    }
}