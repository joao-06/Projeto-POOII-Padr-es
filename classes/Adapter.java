/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author JOÃO
 */
public class Adapter {
    import org.json.JSONObject;
import org.json.XML;

class XMLtoJSONAdapter {
    private ExportData exportData;

    public XMLtoJSONAdapter(ExportData exportData) {
        this.exportData = exportData;
    }

    public String getConvertedData() {
        String xmlData = exportData.getData();
        JSONObject jsonObject = XML.toJSONObject(xmlData); // Converte XML para JSON
        return jsonObject.toString(4); // Retorna JSON formatado
    }
}

}