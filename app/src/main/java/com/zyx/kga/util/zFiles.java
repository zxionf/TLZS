package com.zyx.kga.util;
import android.widget.Toast;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import android.app.Activity;
import java.io.FileReader;

public class zFiles {
    public static String[] bplus(String file,int a){
        String[] s = new String[4];
        String n ="";
        BufferedReader br;
        InputStream is;
        try {
            //is = v.getAssets().open(file);
            FileInputStream fi = new FileInputStream(new File(file));
            is = new BufferedInputStream(fi);

            br = new BufferedReader(new InputStreamReader(is));

            String txt = "";
            int lines = 0;
            while (txt != null) {
                lines++;
                txt = br.readLine();
                if (lines == a) {
                    //System.out.println("第" + br.getLineNumber() + "的内容是：" + txt + "\n");
                    n = txt;
                }
            }
            br.close();
            is.close();
        }catch(Exception e){}
        s[3]  = n;//返回整行
        try{
        String[] strs=n.split("name");
        s[0]= strs[1];//返回name
        s[2]= strs[0];//返回编号
        strs=n.split("ps");
        s[1] = strs[1];//返回PS
        }catch(Exception e){}

        return s;
    }
    
    public static String[] bplus(Activity v,String file,int a){
        String[] s = new String[4];
        String n ="";
        BufferedReader br;
        InputStream is;
        try {
            is = v.getAssets().open(file);
            //FileInputStream fi = new FileInputStream(new File("/storage/emulated/0/00000000/A/app/src/main/assets/achieve_ic/list.txt"));
            //is = new BufferedInputStream(fi);

            br = new BufferedReader(new InputStreamReader(is));
            
            String txt = "";
            int lines = 0;
            while (txt != null) {
                lines++;
                txt = br.readLine();
                if (lines == a) {
                    //System.out.println("第" + br.getLineNumber() + "的内容是：" + txt + "\n");
                    n = txt;
                }
            }
            br.close();
            is.close();
        }catch(Exception e){}
        s[3]  = n;//返回整行
        String[] strs=n.split("name");
        s[0]= strs[1];//返回name
        s[2]= strs[0];//返回编号
        strs=n.split("ps");
        s[1] = strs[1];//返回PS
        

        return s;
    }
    
    public static String b(String path){
        String s = "";
        BufferedReader br;
        InputStream is;
        try {
            //is = getAssets().open("log.txt");
            FileInputStream fi = new FileInputStream(new File(path));
            is = new BufferedInputStream(fi);
            br = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                temp += "\n";
                s = s + temp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }
    public static String b(Activity a,String path){
        String s = "";
        BufferedReader br;
        InputStream is;
        try {
            is = a.getAssets().open(path);
            //FileInputStream fi = new FileInputStream(new File(path));
            //is = new BufferedInputStream(fi);
            br = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                temp += "\n";
                s = s + temp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return s;
    }
    
    public static void file() {
        
        
        
        File file=new File("/storage/emulated/0/0000/x");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {}
        }
        String s = "";
        writeFileAppend("/storage/emulated/0/0000/x", "adkddnbd".getBytes());
        /*BufferedReader br;
        InputStream is;
        try {
            is = getAssets().open("log.txt");
            br = new BufferedReader(new InputStreamReader(is));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                temp += "\n";
                s = s + temp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }

    public static void writeFileAppend(String path, byte[]b) {
        FileOutputStream fs = null;
        BufferedOutputStream bos = null;
        try {
            fs = new FileOutputStream(new File(path), true);//这里改成false则为覆盖的方式写文件
            bos = new BufferedOutputStream(fs);
            bos.write(b);
            bos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fs != null)
                    fs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //读文件
    public static byte[] readFile(String path) {
        int len= (int) new File(path).length();
        byte b[] = new byte[len];
        StringBuffer result=new StringBuffer();
        BufferedInputStream bis = null;
        FileInputStream fi = null;
        try {
            fi = new FileInputStream(new File(path));
            bis = new BufferedInputStream(fi);
            int temp;
            int i=0;
            while ((b[i] = (byte)bis.read()) != -1) {
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fi != null) {
                try {
                    fi.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return b;
    }
    public static int getTextLines(String path) throws IOException {
        // 定义文件路径
        FileReader fr = new FileReader(path); //这里定义一个字符流的输入流的节点流，用于读取文件（一个字符一个字符的读取）
        BufferedReader br = new BufferedReader(fr); // 在定义好的流基础上套接一个处理流，用于更加效率的读取文件（一行一行的读取）
    int x = 0; // 用于统计行数，从0开始
    while(br.readLine() != null) { // readLine()方法是按行读的，返回值是这行的内容
        x++; // 每读一行，则变量x累加1
    }
    fr.close();
    br.close();
    return x; //返回总的行数
    }
    public static int getTextLinesfromassets(Activity activity,String file) throws IOException {
        InputStream is;
        BufferedReader br;
        is = activity.getAssets().open(file);
        //FileInputStream fi = new FileInputStream(new File("/storage/emulated/0/00000000/A/app/src/main/assets/achieve_ic/list.txt"));
        //is = new BufferedInputStream(fi);

        br = new BufferedReader(new InputStreamReader(is));
        int x = 0; // 用于统计行数，从0开始
        while(br.readLine() != null) { // readLine()方法是按行读的，返回值是这行的内容
            x++; // 每读一行，则变量x累加1
        }
        is.close();
        br.close();
        return x; //返回总的行数
    }
}
