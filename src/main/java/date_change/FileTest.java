package date_change;

import java.io.File;

public class FileTest {

    public static void main(String[] args) {
        File f=new File("D:\\word.txt");
        if(f.exists()){
            f.delete();
            System.out.println("文件删除成功");
        }else{
            f.canWrite();
            System.out.println("文件创建成功");
        }


    }
}
