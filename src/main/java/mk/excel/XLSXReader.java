package mk.excel;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import mk.domain.Ranges;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReader {

    public ArrayList<Ranges> xlsx(String path) throws IOException {
        FileInputStream fis2 = new FileInputStream(path);
        XSSFWorkbook wb = new XSSFWorkbook(fis2);
        org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheetAt(0);
        ArrayList<Ranges> ranges = new ArrayList<>();
        for (int j = 1; j < 5; j++) {
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i += 2) {

                if (sheet.getRow(i).getCell(j).toString().trim().length() < 16) {
                    break;
                }
                ranges.add(new Ranges(Long.parseLong(sheet.getRow(i).getCell(j).toString().trim()),
                        Long.parseLong(sheet.getRow(i + 1).getCell(j).toString().trim())));
            }
        }
        return ranges;
    }


}
