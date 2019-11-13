package yuugou3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class yuugou3 {

	public static void main(String[] args) {

		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\all9");
		File[] list = dir.listFiles();
		int count = 0;
		
		for(int j = 0 ;j < list.length; j++)
		{
			//System.out.println(j);
			try {
				FileWriter filew =new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\融合3.txt" ,true);
		        PrintWriter pw = new PrintWriter(new BufferedWriter(filew));
				String[] txtData = new String[5000] ;
				String[][] tyouhukuData = new String[5000][5000] ;
				for(int m = 0; m < 5000 ;m++)
		           {
		        	   for(int n = 0; n < 5000 ;n++)
			           {
			        	   tyouhukuData[m][n]="";

			           }

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
	            String data;
	            while ((data = bufferedReader.readLine()) != null) {
	            	//System.out.println(data);
	            	txtData[ind] = data;
	            	ind++;
	            }
	            int preind = -1;
	            for(int i = 0 ; i < txtData.length - 1 ; i++) {
	            	
	        		if(txtData[i] != null && txtData[i+1] != null) {
	        			if(txtData[i + 1].length() > 2) {
		        			if(txtData[i + 1].charAt(0) == 'E' && txtData[i + 1].charAt(1) == 'O' && txtData[i + 1].charAt(2) == 'S' )
		        			{


		        				if(txtData[i].contains("格解析結果:") && !txtData[i].contains("格解析結果:>")) {
		        					String[] ha1 = txtData[i].split("格解析結果:",-1);



			        					int kaisi[] = new int[50];
			        					int owari[] = new int[50];
			        					int indk = 0;
			        					int indo = 0;
			        					for (int b =0 ;b < 50 ; b++)
			        					{
			        						kaisi[b] = -1;
			        						owari[b] = -1;
			        					}
			        					for(int m = 0;m < ha1[ha1.length - 1].length();m++)
				        				{
				        					if(ha1[ha1.length - 1].charAt(m) == '/')
				        					{
				        						kaisi[indk] = m;
				        						indk++;
			        						}
				        					if(ha1[ha1.length - 1].charAt(m) == ';' || ha1[ha1.length - 1].charAt(m) == '>')
				        					{
				        						owari[indo] = m;
				        						indo++;
			        						}
			        					}
			        					if(indk == indo) {
				        					for(int m = 0;m < indk; m++)
				        					{
				        						tyouhukuData[i][m] = ha1[ha1.length - 1].substring(kaisi[m] +1,owari[m] );

				        						//System.out.println(tyouhukuData[i][m] +"記事"+i +"," +m);
				        					}
				        					if(preind != -1 && tyouhukuData[i][0] != "")
					        				{
					        					for(int k = 0;k < 10;k++)
					        					{
					        						for(int n = 0;n < 10;n++)
						        					{
					        							
						        						if(tyouhukuData[i][k] == tyouhukuData[preind][n] && tyouhukuData[i][k] != "" &&tyouhukuData[preind][n] !="")
						        						{
						        							count++;
						        							
						        							System.out.println("iは" + i + "主語は"+tyouhukuData[preind][n] + "記事番号は" +list[j].getName());
						        						}
						        					}
					        					}
					        					
					        				}
				        					//if(tyouhukuData[i][0] != "")preind = i;
			        					}
			        					//System.out.println("preind"+preind);

		        				//System.out.println(ha1[ha1.length-1]);

		        				}


		        			}
	        			}
	        		}
	        	}
	            int pre = 0;
	            for(int m = 0; m < 5000 ;m++)
		           {
	            	if( pre != m && tyouhukuData[m][0] !="") 
		        	{
		        		   for(int k = 0;k < 5;k++)
	       					{
	       						for(int e = 0;e < 5;e++)
		        				{
	       								if(tyouhukuData[m][k] != "" && tyouhukuData[pre][e] != "") 
	       								{
	       									if(tyouhukuData[m][k].length() == tyouhukuData[pre][e].length())
	       									{
	       										int hantei = 0;
	       										for (int g = 0 ; g <tyouhukuData[m][k].length(); g++) 
	       										{
	       											if(tyouhukuData[m][k].charAt(g) == tyouhukuData[pre][e].charAt(g))hantei++;
	       										}
	       										if(hantei == tyouhukuData[m][k].length())
	       										{
	       											count++;
	       											//pw.println("mは" + m + "主語は"+tyouhukuData[m][k] +" preは "+pre+tyouhukuData[pre][e] + "記事番号は" +list[j].getName());
	       											//pw.println("");
				        							System.out.println("mは" + m + "主語は"+tyouhukuData[m][k] +" preは "+pre+tyouhukuData[pre][e] + "記事番号は" +list[j].getName());
	       										}
	       									}
	       								}

	     			        	   
		        				}
			        	   
	       					}
		        	pre = m;
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
			FileWriter filew =new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\融合3.txt" ,true);
	        PrintWriter pw = new PrintWriter(new BufferedWriter(filew));
	        pw.println("カウントは"+count );
	       
	        //かきこみ
	        pw.close();
	     
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
		System.out.println("カウントは"+count);

	}

}
