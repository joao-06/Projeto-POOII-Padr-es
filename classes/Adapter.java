/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

import java.util.ArrayList;

/**
 *
 * @author JOAO
 */
public class Adapter {
private ImportDataMEC importDataMec; 
private ExportData  exportDate;

public AdapterImport(ImportDataMEC importDataMec, ExportData  exportDate){
 
    this.importDataMec = importDataMec;
    this.exportDate = exportDate;
}

public void exportImport(ArrayList<String[]> data, int multipler, String tag){
    
    String xml = exportDate.ArrayToXMLFormat(data, multipler, tag);
    System.out.println("XML gerado: \n" + xml);
    
    String json = convertxmltoJson(xml);
    System.out.println("Enviando Json para ImportDataMec..." + xml);
    importDataMec.importData(json);
}

private String convertxmltoJson(String xml){
    
    String json = {\ data\": \ " + xml.replace()}
}
