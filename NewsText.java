import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class NewsText {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\k1");
		File[] list = dir.listFiles();
		int nonText = 0;//まだテキストじゃない（「が閉じてないとか）
		for(int j = 0 ;j < list.length; j++) 
		{
			
			try {
				String st1 = "";       
				String[] txtData1 = new String[500];
				String[] txtData2 = new String[500];
				
				for(int a = 0 ;a <500 ;a++) 
				{
					txtData1[a] = "";
					txtData2[a] = "";
				}
				int ind = 0;
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
	            String data ;
	            
	            int p = 0;
	            int ind1 = 0;
	            int ind2 = 0;
	             
	            while ((data = bufferedReader.readLine()) != null) {
	               //System.out.println(data); 	
	        	   if(data.charAt(0) == 'P')p = 1;
	        	   if(p == 0 && data.length() >2)
	        	   {
	        		   txtData1[ind1] = data;
	        		   ind1++;
	        	   }
	        	   if(p == 1 && data.length() >2)
	        	   {
	        		   txtData2[ind2] = data;
	        		   ind2++;
	        	   }
	                	
	                	
	            }
	            
	            /*txtDataに正しく入っているかどうかのチェック
	            int i1 = 0;
	            int i2 = 0;
	            
	            while(txtData1[i1] != "") 
	            {
	            	System.out.println("1");
	            	System.out.println(txtData1[i1]);
	            	i1++;
	            }
	            while(txtData2[i2] != "") 
	            {
	            	System.out.println("2");
	            	System.out.println(txtData2[i2]);
	            	i2++;
	            }
	           /* FileWriter wfile = new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\k1\\"+list[j].getName());
	            PrintWriter pw = new PrintWriter(new BufferedWriter(wfile)); 
	            //かきこみ
	            
	            for(int i = 0 ; i < txtData.length  ; i++) {
	        		if(txtData[i] == null) break;
	        		System.out.println(txtData[i]);
	        	txtData[i] = txtData[i].replaceAll("\r\n","\n");	
	            //pw.println(txtData[i]);
	            
	        	}
	            
	            
	             //最後にファイルを閉じてリソースを開放する
	            pw.close();
	            */
	            bufferedReader.close();
	         
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
    
	}

}
