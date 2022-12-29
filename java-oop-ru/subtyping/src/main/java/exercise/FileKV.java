package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    private String path;

    FileKV(String path, Map<String, String> data) {
        this.path = path;
        String dataString = Utils.serialize(data);
        Utils.writeFile(this.path, dataString);
    }

    @Override
    public void set(String key, String value) {
        String dataString = Utils.readFile(this.path);
        Map<String, String> dataMap = Utils.unserialize(dataString);
        dataMap.put(key, value);
        dataString = Utils.serialize(dataMap);
        Utils.writeFile(this.path, dataString);
    }

    @Override
    public void unset(String key) {
        String dataString = Utils.readFile(this.path);
        Map<String, String> dataMap = Utils.unserialize(dataString);
        dataMap.remove(key);
        dataString = Utils.serialize(dataMap);
        Utils.writeFile(this.path, dataString);

    }

    @Override
    public String get(String key, String defaultValue) {
        String dataString = Utils.readFile(this.path);
        Map<String, String> dataMap = Utils.unserialize(dataString);
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        String dataString = Utils.readFile(this.path);
        return Utils.unserialize(dataString);
    }
}
// END
