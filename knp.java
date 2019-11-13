package knp;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class knp {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\test");
		File[] list = dir.listFiles();
		
		for(int j = 0 ;j < list.length; j++) 
		{
			
			try {
				
	            // ファイルのパスを指定する
	            File file = new File(list[j].getPath());
	         
	            // ファイルが存在しない場合に例外が発生するので確認する
	            if (!file.exists()) {
	                System.out.print("ファイルが存在しません");
	                return;
	            }
	         
	            // BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String data;
	            while ((data = bufferedReader.readLine()) != null) {
	            	System.out.println(data);
	            }

	            //かきこみ
	           
	            bufferedReader.close();
	         
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
    
	}

}
