/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilidades;

import java.io.*;
import javax.swing.*;
import jxl.write.*;
import jxl.*;

public class ExcelTableExporter {

    private File archivo;
    private JTable tabla;
    private String nombreTabla;

    public ExcelTableExporter(JTable tabla, File archivo, String nombreTabla) {
        this.archivo = archivo;
        this.tabla = tabla;
        this.nombreTabla = nombreTabla;
    }

    public boolean export() {
        try {
            DataOutputStream out = new DataOutputStream(new FileOutputStream(archivo));
            WritableWorkbook w = Workbook.createWorkbook(out);
            WritableSheet s = w.createSheet(nombreTabla, 0);

            for (int i = 0; i < tabla.getRowCount(); i++) {
                for (int j = 0; j < tabla.getColumnCount(); j++) {
                    Object objeto = tabla.getValueAt(i, j);
                    s.addCell(new Label(j,i, String.valueOf(objeto)));
                }
            }

            w.write();
            w.close();
            out.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
