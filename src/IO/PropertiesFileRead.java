package IO;

import java.io.*;
import java.util.Properties;

/**
 * Created by Administrator on 2018/6/28.
 *
 * @version 1.0
 * @auther Administrator
 * @date 2018/6/28 11:31
 */
public class PropertiesFileRead {

    private static String filePath = "E:\\MyWork\\WorkSpace\\MyProject\\MyItemSystem\\web\\WEB-INF\\config";
    private static String fileName = "CustomValidationMessage.properties";

    public static void readData()
    {
        Properties pt_gbk = new Properties();;
        Properties pt_utf8 = new Properties();;
        Properties pt_txt = new Properties();;
        try {
            FileInputStream is_gbk = new FileInputStream(filePath+ File.separator + fileName);
            InputStreamReader sr_gbk = new InputStreamReader(is_gbk,"utf-8");
            BufferedReader a = new BufferedReader(sr_gbk);
            pt_gbk.load(sr_gbk);
            System.out.println(pt_gbk);

//            FileInputStream is_utf8 = new FileInputStream(filePath+ File.separator + "CustomValidationMessage.properties.bak");
//            InputStreamReader sr_utf8 = new InputStreamReader(is_utf8,"utf-8");
//            pt_utf8.load(sr_utf8);
//            System.out.println(pt_utf8);

//            FileInputStream is_txt = new FileInputStream(filePath+ File.separator + "txt.txt");
//            InputStreamReader sr_txt = new InputStreamReader(is_txt,"GBK");
//            pt_txt.load(sr_txt);
//            System.out.println(pt_txt);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void main(String[] args) {
        readData();
    }

}
