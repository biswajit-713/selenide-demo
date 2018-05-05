package config;

import java.util.Map;

public class ExecutionInfo {

    private Map<String, String> testConfiguration;

    public Map<String, String> getTestConfiguration() {
        return testConfiguration;
    }

    public void setTestConfiguration(Map<String, String> testConfiguration) {
        this.testConfiguration = testConfiguration;
    }
}
