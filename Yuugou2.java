package Yuugou2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Yuugou2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\all9");
		File[] list = dir.listFiles();
		int count = 0;
		
		for(int j = 0 ;j < list.length; j++) 
		{
			//System.out.println(j);
			try {
				FileWriter filew =new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\融合2.txt" ,true);//true上書きじゃなくで追加される
		        PrintWriter pw = new PrintWriter(new BufferedWriter(filew));
				int nikai =0;
				String[] txtData = new String[5000] ;
				String[][] tyouhukuData = new String[5000][5000] ;
				String[] bunmatu = new String[5000];
				for(int m = 0; m < 5000 ;m++)
		           {
		        	   for(int n = 0; n < 5000 ;n++)
			           {
			        	   tyouhukuData[m][n]="";
			        	   
			           }
		        	   bunmatu[m] = "";
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
	            for(int i = 0 ; i < txtData.length - 1 ; i++) {
	        		if(txtData[i] != null && txtData[i+1] != null) {
	        			if(txtData[i + 1].length() > 2) {
		        			if(txtData[i + 1].charAt(0) == 'E' && txtData[i + 1].charAt(1) == 'O' && txtData[i + 1].charAt(2) == 'S' ) 
		        			{
		        				
		        				
		        				if(txtData[i].contains("格解析結果:") && !txtData[i].contains("格解析結果:>")) {
		        					String[] ha1 = txtData[i].split("格解析結果:",-1); 
		        					String[] ha2 = txtData[i].split("<",0);
			        				String[] ha3 = ha2[0].split(" ");
			        				bunmatu[i] = ha3[ha3.length-1];
			        				
				        				
			        					int kaisi[] = new int[50];
			        					int owari[] = new int[50];
			        					int indk = 0;
			        					int indo = 0;
			        					for (int b =0 ;b < 50 ; b++) 
			        					{
			        						kaisi[b] = -1;
			        						owari[b] = -1;
			        					}
			        					for(int m = 0;m < ha1[ha1.length - 1].length() - 1;m++) 
				        				{
				        					if(ha1[ha1.length - 1].charAt(m) == 'ガ' && ha1[ha1.length - 1].charAt(m + 1) == '/')  
				        					{
				        						kaisi[indk] = m + 1;
				        						indk++;
			        						}
				        				}
			        					for(int m = 0;m < ha1[ha1.length - 1].length() ;m++) 
				        				{	
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
				        						//System.out.println(tyouhukuData[i][m] +m);
				        					}
			        					}
			        					
			        				
		        				System.out.println(ha1[ha1.length-1]);
		        				
		        				}
		        			}
	        			}
	        		}
	        	}
	            //かきこみ
	           for(int m = 0; m < 5000 ;m++)
	           {
	        	   if(bunmatu[m] != "")
	        	   {
	        		   //System.out.println(bunmatu[m]);
	        		   for(int n = 0; n < 5000 ;n++)
	    	           {
	        			   int hantei = 0;
	        			   if(m!=n&&bunmatu[m].length() == bunmatu[n].length()) {
							
					
		        			   for (int g = 0 ; g <bunmatu[m].length(); g++) 
								{
									if(bunmatu[m].charAt(g) == bunmatu[n].charAt(g))hantei++;
								}
							if(hantei == bunmatu[m].length())
							{
								
								 for(int k = 0;k < 5;k++)
			       					{
			       						for(int e = 0;e < 5;e++)
				        				{
			       								if(tyouhukuData[m][k] != "" && tyouhukuData[n][e] != "") 
			       								{
			       									if(tyouhukuData[m][k].length() == tyouhukuData[n][e].length())
			       									{
			       										int hantei2 = 0;
			       										for (int g = 0 ; g <tyouhukuData[m][k].length(); g++) 
			       										{
			       											if(tyouhukuData[m][k].charAt(g) == tyouhukuData[n][e].charAt(g))hantei2++;
			       										}
			       										if(hantei2 == tyouhukuData[m][k].length())
			       										{
			       											
						        							if(nikai == 0 && n-m < 30)
						        							{
						        								//System.out.println(m +"行目と" +n+"行目" + " かぶった主語は"+tyouhukuData[m][k] + " 記事のファイルは" +list[j].getName());
						        								count++;
						        							}
						        							//pw.println(m +"行目と" +n+"行目" + " かぶった主語は"+tyouhukuData[m][k] + " 記事のファイルは" +list[j].getName());
						        							//pw.println("");
						        							nikai++;
			       										}
			       									}
			       								}

			     			        	   
				        				}
					        	   
			       					}
							}
	        			   
	        			   }  
	        			   
	    	           }
	        	   }
	           }
	           
	           
	            bufferedReader.close();
	         pw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
		System.out.println("カウントは"+count);
    
	}

}



/*

package Yuugou2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Yuugou2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\all9");
		File[] list = dir.listFiles();
		int count = 0;
		
		for(int j = 0 ;j < list.length; j++) 
		{
			//System.out.println(j);
			try {
				FileWriter filew =new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\text\\融合2.txt" ,true);
		        PrintWriter pw = new PrintWriter(new BufferedWriter(filew));
				int nikai =0;
				String[] txtData = new String[5000] ;
				String[][] tyouhukuData = new String[5000][5000] ;
				String[] bunmatu = new String[5000];
				for(int m = 0; m < 5000 ;m++)
		           {
		        	   for(int n = 0; n < 5000 ;n++)
			           {
			        	   tyouhukuData[m][n]="";
			        	   
			           }
		        	   bunmatu[m] = "";
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
	            for(int i = 0 ; i < txtData.length - 1 ; i++) {
	        		if(txtData[i] != null && txtData[i+1] != null) {
	        			if(txtData[i + 1].length() > 2) {
		        			if(txtData[i + 1].charAt(0) == 'E' && txtData[i + 1].charAt(1) == 'O' && txtData[i + 1].charAt(2) == 'S' ) 
		        			{
		        				
		        				
		        				if(txtData[i].contains("格解析結果:") && !txtData[i].contains("格解析結果:>")) {
		        					String[] ha1 = txtData[i].split("格解析結果:",-1); 
		        					String[] ha2 = txtData[i].split("<",0);
			        				String[] ha3 = ha2[0].split(" ");
			        				bunmatu[i] = ha3[ha3.length-1];
			        				
				        				
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
				        						//System.out.println(tyouhukuData[i][m] +m);
				        					}
			        					}
			        					
			        				
		        				System.out.println(ha1[ha1.length-1]);
		        				
		        				}
		        			}
	        			}
	        		}
	        	}
	            //かきこみ
	           for(int m = 0; m < 5000 ;m++)
	           {
	        	   if(bunmatu[m] != "")
	        	   {
	        		   //System.out.println(bunmatu[m]);
	        		   for(int n = 0; n < 5000 ;n++)
	    	           {
	        			   int hantei = 0;
	        			   if(m!=n&&bunmatu[m].length() == bunmatu[n].length()) {
							
					
		        			   for (int g = 0 ; g <bunmatu[m].length(); g++) 
								{
									if(bunmatu[m].charAt(g) == bunmatu[n].charAt(g))hantei++;
								}
							if(hantei == bunmatu[m].length())
							{
								
								 for(int k = 0;k < 5;k++)
			       					{
			       						for(int e = 0;e < 5;e++)
				        				{
			       								if(tyouhukuData[m][k] != "" && tyouhukuData[n][e] != "") 
			       								{
			       									if(tyouhukuData[m][k].length() == tyouhukuData[n][e].length())
			       									{
			       										int hantei2 = 0;
			       										for (int g = 0 ; g <tyouhukuData[m][k].length(); g++) 
			       										{
			       											if(tyouhukuData[m][k].charAt(g) == tyouhukuData[n][e].charAt(g))hantei2++;
			       										}
			       										if(hantei2 == tyouhukuData[m][k].length())
			       										{
			       											
						        							if(nikai == 0 && n-m < 30)
						        							{
						        								//System.out.println(m +"行目と" +n+"行目" + " かぶった主語は"+tyouhukuData[m][k] + " 記事のファイルは" +list[j].getName());
						        								count++;
						        							}
						        							//pw.println(m +"行目と" +n+"行目" + " かぶった主語は"+tyouhukuData[m][k] + " 記事のファイルは" +list[j].getName());
						        							//pw.println("");
						        							nikai++;
			       										}
			       									}
			       								}

			     			        	   
				        				}
					        	   
			       					}
							}
	        			   
	        			   }  
	        			   
	    	           }
	        	   }
	           }
	           
	           
	            bufferedReader.close();
	         pw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
		System.out.println("カウントは"+count);
    
	}

}
*/