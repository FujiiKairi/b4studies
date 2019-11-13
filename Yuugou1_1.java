package Yuugou1_1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Yuugou1_1 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\all8");
		File[] list = dir.listFiles();
		int[] count = new int[10];
		for(int y =0 ;y < 10; y ++)
		{
			count[y] = 0;
		}
		int pareText = 0;
		for(int j = 0 ;j < list.length; j++) 
		{
			
			try {
				FileWriter filew =new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\融合1_2.txt" ,true);
		        PrintWriter pw = new PrintWriter(new BufferedWriter(filew));
	            // ファイルのパスを指定する
	            File file = new File(list[j].getPath());
	            int ind = 0;
	            String[] txtData = new String[5000];
	            // ファイルが存在しない場合に例外が発生するので確認する
	            if (!file.exists()) {
	                System.out.print("ファイルが存在しません");
	                return;
	            }
	         
	            // BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            String data;
	            
	            while ((data = bufferedReader.readLine()) != null) 
	            {
	            	txtData[ind] = data;
	            	ind++;
	           	}
	            for(int i = 0 ; i < txtData.length - 2 ; i++) {
	        		if(txtData[i] != null && txtData[i+1] != null && txtData[i+2] != null) {
	        			pareText++;
	        			
	        			if(txtData[i].length() +  txtData[i + 1].length() + txtData[i + 2].length() <=40)
		        		{
	        				if(CheckText(txtData[i]) == true && CheckText(txtData[i+1]) == true && CheckText(txtData[i+2]) == true) 
	        				{
	        					count[3]++;
	        					System.out.println("3文の融合");
	        					System.out.println(txtData[i]);
	        					System.out.println(txtData[i+1]);
	        					System.out.println(txtData[i+2]);
	        					pw.println("3文の融合");
	        					pw.println(txtData[i]);
	        					pw.println(txtData[i+1]);
	        					pw.println(txtData[i+2]);
	        					pw.println("");
	        				}
		        		}
	        			
		        		
	        				
		        		
	        		}
	        	}
	            for(int i = 0 ; i < txtData.length - 3 ; i++) {
	        		if(txtData[i] != null && txtData[i+1] != null && txtData[i+2] != null&& txtData[i+3] != null) {
	        			pareText++;
	        			
	        			if(txtData[i].length() +  txtData[i + 1].length() + txtData[i + 2].length() + txtData[i + 3].length()<=40)
		        		{
	        				if(CheckText(txtData[i]) == true && CheckText(txtData[i+1]) == true && CheckText(txtData[i+2]) == true&& CheckText(txtData[i+3]) == true) 
	        				{
	        					count[4]++;
	        					System.out.println("4文の融合");
	        					System.out.println(txtData[i]);
	        					System.out.println(txtData[i+1]);
	        					System.out.println(txtData[i+2]);
	        					System.out.println(txtData[i+3]);
	        				}
		        		}
	        			
		        		
	        				
		        		
	        		}
	        	}
	            //かきこみ
	           pw.close();
	            bufferedReader.close();
	         
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
		try {
			FileWriter filew =new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\融合1_1.txt" ,true);
	        PrintWriter pw = new PrintWriter(new BufferedWriter(filew));
	        
	        pw.println("3文の回数は"+count[3]);
	        int a = count[4] - 1;
	        pw.println("4文の回数は"+a);
	        //かきこみ
	        pw.close();
	     
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	System.out.println("すべての文の数"+pareText + 1);
    
    	System.out.println("3文の回数は"+count[3]);
    	System.out.println("4文の回数は"+count[4]);
    
		
	}

	private static boolean CheckText(String st1) {
		if(st1.length() < 10)return false ;
		if(st1.charAt(0) == '・' || st1.charAt(0) == '「' || st1.charAt(0) == '『' || st1.charAt(0) == '■'
				 || st1.charAt(0) == '【' || st1.charAt(0) == '＜'|| st1.charAt(0) == '（'|| st1.charAt(0) == '—'
				 || st1.charAt(st1.length() - 1) == '】' || st1.charAt(st1.length() - 1) == '＞'|| st1.charAt(0) == '」'
				 || st1.charAt(0) == '〈'|| st1.charAt(0) == '）'|| st1.charAt(0) == '>'|| st1.charAt(0) == ' '
				 || st1.charAt(0) == '｛' || st1.charAt(0) == '★'|| st1.charAt(0) == '●'|| st1.charAt(0) == '※'
				 || st1.charAt(0) == '◆'|| st1.charAt(0) == '☆'|| st1.charAt(0) == '◯'|| st1.charAt(0) == '◎'
				 || st1.charAt(0) == '◇' || st1.charAt(0) == '-'|| st1.charAt(0) == '('|| st1.charAt(0) == '*'
				 || st1.charAt(0) == 'A' || st1.charAt(0) == 'B'|| st1.charAt(0) == 'C'|| st1.charAt(0) == 'D'
				 || st1.charAt(0) == '1' || st1.charAt(0) == '2'|| st1.charAt(0) == '3'|| st1.charAt(0) == '4'
				 || st1.charAt(0) == '5' || st1.charAt(0) == '6'|| st1.charAt(0) == '7'|| st1.charAt(0) == '8'
			   	 || st1.charAt(0) == '１' || st1.charAt(0) == '２'|| st1.charAt(0) == '３'|| st1.charAt(0) == '４'
				 || st1.charAt(0) == '５' || st1.charAt(0) == '６'|| st1.charAt(0) == '７'|| st1.charAt(0) == '８'
				 || st1.charAt(0) == '○'|| st1.charAt(0) == '□'|| st1.charAt(0) == '〇'|| st1.charAt(0) == '•'
				 || st1.charAt(0) == '重'
				 || st1.charAt(st1.length() - 1) == '」'|| st1.charAt(st1.length() - 1) == '』'
				 || st1.charAt(st1.length() - 1) == '｝'|| st1.charAt(st1.length() - 1) == '）'
				 || st1.charAt(st1.length() - 1) == '♡'|| st1.charAt(st1.length() - 1) == ')'
				 || st1.charAt(st1.length() - 1) == 'ー'|| st1.charAt(st1.length() - 1) == '！'
				 || st1.charAt(st1.length() - 1) == '？'|| st1.charAt(st1.length() - 1) == '、'
				 || st1.charAt(st1.length() - 1) == '*'|| st1.charAt(st1.length() - 1) == '〜'
				 || st1.charAt(st1.length() - 1) == '」'|| st1.charAt(st1.length() - 1) == '）'
				 || st1.charAt(st1.length() - 1) == '…'|| st1.charAt(st1.length() - 1) == '—'
				 || st1.charAt(st1.length() - 1) == ' '|| st1.charAt(st1.length() - 1) == 'g'
				 || st1.charAt(st1.length() - 1) == 'ぜ'
				 || st1.charAt(st1.length() - 1) == '♪'|| st1.charAt(st1.length() - 1) == 'ｗ')return false;
		
		for(int i = 0;i < st1.length();i++) 
		{
			if(st1.charAt(i) == '：')  return false;
			if(st1.charAt(i) == ':')  return false;
		}
		
		if(st1.charAt(st1.length() - 4) == 'ま' && st1.charAt(st1.length() - 3) == 'し' && st1.charAt(st1.length() - 2) == 'ょ' && st1.charAt(st1.length() - 1) == 'う' )return false;
		if(st1.charAt(st1.length() - 4) == 'た' && st1.charAt(st1.length() - 3) == 'ん' && st1.charAt(st1.length() - 2) == 'で' && st1.charAt(st1.length() - 1) == 'す' )return false;
		if(st1.charAt(st1.length() - 4) == 'い' && st1.charAt(st1.length() - 3) == 'ん' && st1.charAt(st1.length() - 2) == 'で' && st1.charAt(st1.length() - 1) == 'す' )return false;
		if(st1.charAt(st1.length() - 4) == 'な' && st1.charAt(st1.length() - 3) == 'の' && st1.charAt(st1.length() - 2) == 'で' && st1.charAt(st1.length() - 1) == 'す' )return false;
		if(st1.charAt(st1.length() - 4) == 'し' && st1.charAt(st1.length() - 3) == 'ょ' && st1.charAt(st1.length() - 2) == 'う' && st1.charAt(st1.length() - 1) == 'か' )return false;
		if(st1.charAt(st1.length() - 4) == 'ま' && st1.charAt(st1.length() - 3) == 'し' && st1.charAt(st1.length() - 2) == 'た' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 4) == 'で' && st1.charAt(st1.length() - 3) == 'し' && st1.charAt(st1.length() - 2) == 'ょ' && st1.charAt(st1.length() - 1) == 'う' )return false;
		if(st1.charAt(st1.length() - 3) == 'け' && st1.charAt(st1.length() - 2) == 'ど' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 3) == 'ま' && st1.charAt(st1.length() - 2) == 'し' && st1.charAt(st1.length() - 1) == 'た' )return false;
		if(st1.charAt(st1.length() - 3) == 'で' && st1.charAt(st1.length() - 2) == 'す' && st1.charAt(st1.length() - 1) == 'よ' )return false;
		if(st1.charAt(st1.length() - 3) == 'だ' && st1.charAt(st1.length() - 2) == 'よ' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 3) == 'る' && st1.charAt(st1.length() - 2) == 'ん' && st1.charAt(st1.length() - 1) == 'だ' )return false;
		if(st1.charAt(st1.length() - 3) == 'で' && st1.charAt(st1.length() - 2) == 'す' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 3) == 'で' && st1.charAt(st1.length() - 2) == 'す' && st1.charAt(st1.length() - 1) == 'か' )return false;
		if(st1.charAt(st1.length() - 3) == 'か' && st1.charAt(st1.length() - 2) == 'ら' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 3) == 'さ' && st1.charAt(st1.length() - 2) == 'い' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 3) == 'だ' && st1.charAt(st1.length() - 2) == 'ろ' && st1.charAt(st1.length() - 1) == 'う' )return false;
		if(st1.charAt(st1.length() - 3) == 'な' && st1.charAt(st1.length() - 2) == 'さ' && st1.charAt(st1.length() - 1) == 'い' )return false;
		if(st1.charAt(st1.length() - 3) == 'の' && st1.charAt(st1.length() - 2) == 'で' && st1.charAt(st1.length() - 1) == 'す' )return false;
		if(st1.charAt(st1.length() - 3) == 'か' && st1.charAt(st1.length() - 2) == 'も' && st1.charAt(st1.length() - 1) == 'な' )return false;
		if(st1.charAt(st1.length() - 3) == 'す' && st1.charAt(st1.length() - 2) == 'る' && st1.charAt(st1.length() - 1) == 'わ' )return false;
		if(st1.charAt(st1.length() - 3) == 'だ' && st1.charAt(st1.length() - 2) == 'そ' && st1.charAt(st1.length() - 1) == 'う' )return false;
		if(st1.charAt(st1.length() - 3) == 'も' && st1.charAt(st1.length() - 2) == 'ん' && st1.charAt(st1.length() - 1) == 'な' )return false;
		if(st1.charAt(st1.length() - 3) == 'い' && st1.charAt(st1.length() - 2) == 'い' && st1.charAt(st1.length() - 1) == 'ね' )return false;
		if(st1.charAt(st1.length() - 3) == 'か' && st1.charAt(st1.length() - 2) == 'ら' && st1.charAt(st1.length() - 1) == 'な' )return false;
		if(st1.charAt(st1.length() - 3) == 'し' && st1.charAt(st1.length() - 2) == 'よ' && st1.charAt(st1.length() - 1) == 'う' )return false;
		if(st1.charAt(st1.length() - 3) == 'な' && st1.charAt(st1.length() - 2) == 'い' && st1.charAt(st1.length() - 1) == 'よ' )return false;
		if(st1.charAt(st1.length() - 2) == 'ま' && st1.charAt(st1.length() - 1) == 'す' )return false;
		if(st1.charAt(st1.length() - 2) == 'で' && st1.charAt(st1.length() - 1) == 'す' )return false;
		if(st1.charAt(st1.length() - 2) == 'け' && st1.charAt(st1.length() - 1) == 'ど' )return false;
		if(st1.charAt(st1.length() - 2) == 'の' && st1.charAt(st1.length() - 1) == 'だ' )return false;
		if(st1.charAt(st1.length() - 2) == 'の' && st1.charAt(st1.length() - 1) == 'よ' )return false;
		if(st1.charAt(st1.length() - 2) == 'も' && st1.charAt(st1.length() - 1) == 'ん' )return false;
		if(st1.charAt(st1.length() - 2) == 'B' && st1.charAt(st1.length() - 1) == 'K' )return false;
		if(st1.charAt(st1.length() - 2) == 'L' && st1.charAt(st1.length() - 1) == 'B' )return false;
		if(st1.charAt(st1.length() - 2) == 'R' && st1.charAt(st1.length() - 1) == 'D' )return false;
		
		
		
		int a = 0;
		int b = 0;
		for(int i = 0;i < st1.length();i++)
		{
			if(st1.charAt(i) == '「')  a = 1;
			if(st1.charAt(i) == '」')  b = 1;
		}
		if((a == 1 && b == 0) || (a == 0 && b == 1))return false; 
		
		
		
		return true;
	}

}

