package classes;

import java.util.ArrayList;

public class XMLToJSONAdapter {
    private ExportData exportData;

    public XMLToJSONAdapter(ExportData exportData) {
        this.exportData = exportData;
    }

    public String convertXMLToJSON(ArrayList<String[]> data, int multiplier, String tag) {
        if (data == null || data.isEmpty()) {
            return "{\"data\": []}";
        }

        StringBuilder json = new StringBuilder();
        json.append("{\n  \"data\": [\n");

        for (int i = 0; i < data.size(); i++) {
            if (i % multiplier == 0) {
                if (i != 0) {
                    json.append("    },\n");
                }
                json.append("    {\n");
            }

            String key = data.get(i)[0];
            String value = data.get(i)[1] != null ? data.get(i)[1] : "";
            json.append(String.format("      \"%s\": \"%s\"", key, value));
            if (i % multiplier != multiplier - 1 && i != data.size() - 1) {
                json.append(",");
            }
            json.append("\n");

            if (i % multiplier == multiplier - 1 || i == data.size() - 1) {
                json.append("    }");
                if (i != data.size() - 1) {
                    json.append(",");
                }
                json.append("\n");
            }
        }

        json.append("  ]\n}");
        return json.toString();
    }
}