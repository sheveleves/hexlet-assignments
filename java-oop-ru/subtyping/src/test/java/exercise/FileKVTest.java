package exercise;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import com.fasterxml.jackson.databind.ObjectMapper;

// BEGIN
import java.util.Map;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
// END


class FileKVTest {

    private static Path filepath = Paths.get("src/test/resources/file").toAbsolutePath().normalize();

    @BeforeEach
    public void beforeEach() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(new HashMap<String, String>());
        Files.writeString(filepath, content, StandardOpenOption.CREATE);
    }

    // BEGIN
    @Test
    void fileKVTest() {
        KeyValueStorage storage = new FileKV(filepath.toString(), Map.of("key", "value"));
        assertThat(storage.get("key", "default")).isEqualTo("value");
        storage.set("key2", "value2");
        assertThat(storage.get("key2", "default")).isEqualTo("value2");
        assertThat(storage.get("key3", "default")).isEqualTo("default");
        storage.set("key2", "value3");
        storage.set("key4", "value4");
        assertThat(storage.get("key2", "default")).isEqualTo("value3");
        assertThat(storage.get("key4", "default")).isEqualTo("value4");
        storage.unset("key2");
        assertThat(storage.get("key2", "default")).isEqualTo("default");
        Map<String, String> map = Map.of("key", "value", "key4", "value4");
        assertThat(storage.toMap()).isEqualTo(map);
    }
    // END
}
