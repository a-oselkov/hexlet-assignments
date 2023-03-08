package exercise;

// BEGIN
public class FileKV implements KeyValueStorage{

    private String path;
    private Map<String, String> storage = new HashMap<>();

    public FileKV(String path, Map<String, String> storage) {
        this.path = path;
        this.storage.putAll(storage);
        Utils.writeFile(this.path, Utils.serialize(this.storage));
    }

    @Override
    public void set(String key, String value) {
        Map<String, String> map = Utils.unserialize(Utils.readFile(path));
        map.put(key, value);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public void unset(String key) {
        Map<String, String> map = Utils.unserialize(Utils.readFile(path));
        map.remove(key);
        Utils.writeFile(path, Utils.serialize(map));
    }

    @Override
    public String get(String key, String defaultValue) {
        Map<String, String> map = Utils.unserialize(Utils.readFile(path));
        if (map.containsKey(key)) {
            return map.get(key);
        }
        return defaultValue;
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.readFile(path));
    }
}
// END
