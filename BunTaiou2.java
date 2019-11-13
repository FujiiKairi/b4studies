import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BunTaiou2 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\文文節語\\k1");
		File[] list = dir.listFiles();
		File knpdir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\文文節語\\kknp");
		File[] knplist= knpdir.listFiles();
		
		
		for(int j = 0 ;j < list.length; j++) 
		{
			String[] txtData1 = new String[500];
			String[] txtData2 = new String[500];
			String[] preKnpData = new String[500];
			String[][] knpData1 = new String[500][500];
			String[][] knpData2 = new String[500][500];
			
			int[] bunsetuInd1 = new int[50];
			int[] bunsetuInd2 = new int[50];
			
			int[][] pareCount = new int[50][50];
			
			for(int a = 0 ;a <50 ;a++) 
			{
				 bunsetuInd1[a] = 0 ;
				 bunsetuInd2[a] = 0 ;
				 for(int a1 = 0 ;a1 <50 ;a1++) 
					{
						pareCount[a][a1] = 0;
					}
			}
			for(int a = 0 ;a <500 ;a++) 
			{
				txtData1[a] = "";
				txtData2[a] = "";
				preKnpData[a] = "";
				
				for(int b = 0; b < 500 ; b++) 
				{
					knpData1[a][b] = "";
					knpData2[a][b] = "";
				}
			}
			try {
				
				
	            // ファイルのパスを指定する
	            File file = new File(list[j].getPath());
	            File knpfile = new File(knplist[j].getPath());
	            // ファイルが存在しない場合に例外が発生するので確認する
	            if (!file.exists()) {
	                System.out.print("ファイルが存在しません");
	                return;
	            }
	            if (!knpfile.exists()) {
	                System.out.print("ファイルが存在しません");
	                return;
	            }
	            // BufferedReaderクラスのreadLineメソッドを使って1行ずつ読み込み表示する
	            FileReader fileReader = new FileReader(file);
	            BufferedReader bufferedReader = new BufferedReader(fileReader);
	            
	            FileReader knpFileReader = new FileReader(knpfile);
	            BufferedReader knpBufferedReader = new BufferedReader(knpFileReader);
	            String data ;
	            String knpData;
	            
	            int kind1 = 0;
	            
	            while ((knpData = knpBufferedReader.readLine()) != null) {
	            	//System.out.println(knpData);
	            	preKnpData[kind1] = knpData;
	            	kind1++;
	            }
	            
	            int numText = 0;
	            int preEOS = 0;
	            int pKnp = 0;
	            int firstInd = 0;
	            for(int i = 0 ; i < preKnpData.length ; i++) {
	        		preKnpData[i] = preKnpData[i].replaceAll("　","");
	        		preKnpData[i] = preKnpData[i].replaceAll(" ","");
	        		
		        	if(preKnpData[i].length() >2 && preKnpData[i]!= ""&& preKnpData[i]!= null) {	
	        			if(preKnpData[i].charAt(0) == 'P' &&preKnpData[i].charAt(1) == 'E' && preKnpData[i].charAt(2) == 'O' && preKnpData[i].charAt(3) == 'S' ) 
	        			{
	        				pKnp = 1;
	        			}
		        		
	        			if(pKnp == 0) 
	        			{
	        				
		        			if(preKnpData[i].charAt(0) == 'E' && preKnpData[i].charAt(1) == 'O' && preKnpData[i].charAt(2) == 'S' ) 
				        	{
		        				
		        				firstInd = 0;
				        			
		        				if(preEOS == 0)numText++;
				        		preEOS = 1;
				        		
				        	}
			        		else 
			        		{
			        			preEOS = 0;
			        			
			        		}
		        			
		        			if(preEOS == 0  && preKnpData[i]!= null)
		        			{
		        				//System.out.println(preKnpData[i]);
		        				int a = 0;
		        				while(preKnpData[i].charAt(a) != '─' && preKnpData[i].charAt(a) != '<'  &&preKnpData[i].length() > a + 1) 
		        				{
		        					a++;
		        				}
		        				preKnpData[i] = preKnpData[i].substring(0,a);
		        				if( preKnpData[i].length() < 20)
		        				{
			        				knpData1[numText][firstInd] = preKnpData[i];
			        				//System.out.println("numtext"+numText);
			        				//System.out.println("firstInd"+firstInd);
			        				//System.out.println(knpData1[numText][firstInd]);
			        				firstInd++;
		        				}
		        			}
	        			}
	        			
	        			if(pKnp == 1)
	        			{
	        				
	        				numText = 0;
	        	            preEOS = 1;
	        	            firstInd = 0;
	        	            pKnp = 2;
	        			}
	        			if(pKnp == 2 && !(preKnpData[i].charAt(0) == 'E' && preKnpData[i].charAt(1) == 'O' && preKnpData[i].charAt(2) == 'S' ))
	        			{
	        				pKnp = 3;
	        			}
	        			else if(pKnp == 3) 
	        			{
	        				
		        			if(preKnpData[i].charAt(0) == 'E' && preKnpData[i].charAt(1) == 'O' && preKnpData[i].charAt(2) == 'S'  ) 
				        	{
		        				
		        				firstInd = 0;
				        			
		        				if(preEOS == 0)numText++;
				        		preEOS = 1;
				        	}
			        		else 
			        		{
			        			preEOS = 0;
			        			
			        		}
		        			
		        			if(preEOS == 0 && preKnpData[i].charAt(1) != 'S' )
		        			{
		        				int a = 0;
		        				while(preKnpData[i].charAt(a) != '─' && preKnpData[i].charAt(a) != '<'  &&preKnpData[i].length() > a + 1) 
		        				{
		        					a++;
		        				}
		        				preKnpData[i] = preKnpData[i].substring(0,a);
		        				if( preKnpData[i].length() < 20)
		        				{
			        				knpData2[numText][firstInd] = preKnpData[i];
			        				//System.out.println("numtext"+numText);
			        				//System.out.println("firstInd"+firstInd);
			        				//System.out.println(knpData2[numText][firstInd]);
			        				firstInd++;
		        				}
		        				
		        			}
	        			}
	        			
		        	}
	        		
	        	}
	           
	            //文対応↓
	            int ind1 = 0;
	            int ind2 = 0;
	            int p = 0;
	            while ((data = bufferedReader.readLine()) != null) {
	               if(data.charAt(0) == 'P')p = 1;
	               else if(p == 0 && data != "")
	               {
	            	   
	            	   txtData1[ind1] = data.replace("。","");
	            	   ind1++;
	               }
	               else if(p == 1 && data != "")
	               {
	            	   txtData2[ind2] = data.replace("。","");
	            	   ind2++;
	               }
	            }
	            for(int r1 = 0; r1 < ind1 ;r1++) 
	            {
	            	for(int r2 = 0; r2 < ind2 ;r2++) 
		            {
		            	if(txtData1[r1].contains(txtData2[r2])) 
		            	{
		            		txtData2[r2] ="";
		            		for(int h = 0; h < 500 ;h++) 
		            		{
		            			knpData2[r2][h]="";//文対応で包含されるものを文節で考えなくする。
		            		}
		            	}
		            	if(txtData2[r2].contains(txtData1[r1]))
		            	{
		            		txtData1[r1] ="";
		            		for(int h = 0; h < 500 ;h++) 
		            		{
		            			knpData1[r1][h]="";//文対応で包含されるものを文節で考えなくする。
		            		}
		            	}
		            }
	            }
	            
	            //----------------------------------------------------------------------
	            
	            //↓文節でどれくらい対応するか。
	            int r1 = 0;
	            int r2 = 0;
	            while(knpData1[r1][0] != "")
	            {
	            	r1++;
	            }
	            for(int h = 0; h < r1 ;h++)
	            {
	            	int g = 0;
	            	while(knpData1[h][g] != "")
	            	{
	            		g++;
	            	}
	            	bunsetuInd1[h] = g;
	            }
	            
	            while(knpData2[r2][0] != "")
	            {
	            	r2++;
	            }
	            for(int h = 0; h < r2 ;h++)
	            {
	            	int g = 0;
	            	while(knpData2[h][g] != "")
	            	{
	            		g++;
	            	}
	            	bunsetuInd2[h] = g;
	            }
	            
	            
	            //-----------------------------------------------------------------------
	            
	            int h1 =0;
	            int h2 =0;
	            
	            while(bunsetuInd1[h1] != 0)
	            {
	            	while(bunsetuInd2[h2] != 0)
		            {
		            	for(int a1 =0;a1 < bunsetuInd1[h1] ;a1++)
		            	{
		            		for(int a2 =0; a2 < bunsetuInd2[h2] ;a2++)
		            		{
		            			if(knpData1[h1][a1].length() == knpData2[h2][a2].length())
		            			{
		            				int hantei = 0;
		            				for (int g = 0 ; g <knpData1[h1][a1].length(); g++) 
									{
										if(knpData1[h1][a1].charAt(g) == knpData2[h2][a2].charAt(g))hantei++;
									}
								if(hantei == knpData1[h1][a1].length()) 
								{
									pareCount[h1][h2]++;
								}
		            				
		            				
		            			}
		            		}
		            	}
	            		
	            		h2++;
		            }
	            	h1++;
	            	h2 = 0;
	            }
	            
	            
	            for(int j1 = 0; j1 <50 ;j1++) {
	            	for(int j2 =0; j2 < 50 ;j2++){
	            		if(pareCount[j1][j2] != 0) {
		            		//System.out.println("1j "+j1+"文目");
		            		//System.out.println("2j "+j2+"文目");
		            		//System.out.println("bunsetu1 "+bunsetuInd1[j1]);
		            		//System.out.println("bunsetu2 "+bunsetuInd2[j2]);
		            		//System.out.println(pareCount[j1][j2]);
	            			if(pareCount[j1][j2] > 4)
	            			{
	            				double f1 = j1;
	            				double f2 = j2;
	            				if(f1 * 0.4 <pareCount[j1][j2] || f2 * 0.4 <pareCount[j1][j2])
	            				{
	            					if(bunsetuInd1[j1] >= bunsetuInd2[j2])//j1のほうを分厚くする
	            					{
	            						int doYuugou = 0;
	            						for(int l = 0; l <bunsetuInd1[j1] - 1 ; l++)
	            						{
	            							for(int y1 = 0; y1 <bunsetuInd2[j2] ; y1++)
	            							{
	            								for(int y2 = y1 + 2; y2 <bunsetuInd2[j2] ; y2++)
		            							{
		            								if(knpData1[j1][l].length() == knpData2[j2][y1].length() && knpData1[j1][l+1].length() == knpData2[j2][y2].length())
		            								{
		            									int hantei = 0;
		            		            				for (int g = 0 ; g <knpData1[j1][l].length(); g++) 
		            									{
		            										if(knpData1[j1][l].charAt(g) == knpData2[j2][y1].charAt(g))hantei++;
		            									}
		            		            				for (int g = 0 ; g <knpData1[j1][l+1].length(); g++) 
		            									{
		            										if(knpData1[j1][l+1].charAt(g) == knpData2[j2][y2].charAt(g))hantei++;
		            									}
			            								if(hantei == knpData1[j1][l].length() + knpData1[j1][l+1].length() ) 
			            								{
			            									//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+knpData1[j1][l]);
			            									//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+knpData1[j1][l+1]);
			            									int hantei2 = 0;
			            									for(int p1 = y1 + 1; p1 < y2 ; p1++)
			    	            							{
			    	            								for(int p2 = 0; p2 < bunsetuInd1[j1]; p2++)
			    	            								{
			    	            									//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+knpData2[j2][p1]);
			    	            									if( knpData1[j1][p2].length() == knpData2[j2][p1].length())
			    	            									{
			    	            										int hantei3 = 0;
			    		            		            				for (int g = 0 ; g < knpData1[j1][p2].length(); g++) 
			    		            									{
			    		            										if(knpData1[j1][p2].charAt(g) == knpData2[j2][p1].charAt(g))hantei3++;
			    		            									}
			    		            		            				if(hantei3 == knpData1[j1][p2].length())
			    		            		            				{
			    		            		            					hantei2 =1;
			    		            		            				}
			    	            									}
			    	            								}
			    		            						}
				            								
			            									if(hantei2 == 0)
			            									{
			            										doYuugou = 1;
				            									txtData2[j2] = "";
				            									txtData1[j1] = "";
				            									for(int v = 0; v < l ;v++)
				            									{
				            										txtData1[j1] = txtData1[j1] + knpData1[j1][v];
				            									}
				            									for(int v = y1; v < y2 ; v ++)
				            									{
				            										txtData1[j1] = txtData1[j1] + knpData2[j2][v];
				            									}
				            									for(int v = l + 1; v < bunsetuInd1[j1] ;v++)
				            									{
				            										txtData1[j1] = txtData1[j1] + knpData1[j1][v];
				            									}
				            									System.out.println(txtData1[j1]);
			            									}
			            								}
		            								}
		            							}
	            							}
	            						}
	            						if(doYuugou == 0)
	            						{
	            							txtData2[j2] = "";
	            						}
	            					}
	            					else 
	            					{
	            						int doYuugou = 0;
	            						for(int l = 0; l <bunsetuInd2[j2] - 1 ; l++)
	            						{
	            							for(int y1 = 0; y1 <bunsetuInd1[j1] ; y1++)
	            							{
	            								for(int y2 = y1 + 2; y2 <bunsetuInd1[j1] ; y2++)
		            							{
		            								if(knpData2[j2][l].length() == knpData1[j1][y1].length() && knpData2[j2][l+1].length() == knpData1[j1][y2].length())
		            								{
		            									int hantei = 0;
		            		            				for (int g = 0 ; g <knpData2[j2][l].length(); g++) 
		            									{
		            										if(knpData2[j2][l].charAt(g) == knpData1[j1][y1].charAt(g))hantei++;
		            									}
		            		            				for (int g = 0 ; g <knpData2[j2][l+1].length(); g++) 
		            									{
		            										if(knpData2[j2][l+1].charAt(g) == knpData1[j1][y2].charAt(g))hantei++;
		            									}
			            								if(hantei == knpData2[j2][l].length() + knpData2[j2][l+1].length() ) 
			            								{
			            									//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+knpData1[j1][l]);
			            									//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+knpData1[j1][l+1]);
			            									int hantei2 = 0;
			            									for(int p1 = y1 + 1; p1 < y2 ; p1++)
			    	            							{
			    	            								for(int p2 = 0; p2 < bunsetuInd2[j2]; p2++)
			    	            								{
			    	            									//System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa"+knpData2[j2][p1]);
			    	            									if( knpData2[j2][p2].length() == knpData1[j1][p1].length())
			    	            									{
			    	            										int hantei3 = 0;
			    		            		            				for (int g = 0 ; g < knpData2[j2][p2].length(); g++) 
			    		            									{
			    		            										if(knpData2[j2][p2].charAt(g) == knpData1[j1][p1].charAt(g))hantei3++;
			    		            									}
			    		            		            				if(hantei3 == knpData2[j2][p2].length())
			    		            		            				{
			    		            		            					hantei2 =1;
			    		            		            				}
			    	            									}
			    	            								}
			    		            						}
				            								
			            									if(hantei2 == 0)
			            									{
				            									txtData2[j2] = "";
				            									txtData1[j1] = "";
				            									for(int v = 0; v < l ;v++)
				            									{
				            										txtData2[j2] = txtData2[j2] + knpData2[j2][v];
				            									}
				            									for(int v = y1; v < y2 ; v ++)
				            									{
				            										txtData2[j2] = txtData2[j2] + knpData1[j1][v];
				            									}
				            									for(int v = l + 1; v < bunsetuInd2[j2] ;v++)
				            									{
				            										txtData2[j2] = txtData2[j2] + knpData2[j2][v];
				            									}
				            									System.out.println(txtData2[j2]);
			            									}
			            								}
		            								}
		            							}
	            							}
	            						}
	            						if(doYuugou == 0)
	            						{
	            							txtData1[j1] = "";
	            						}
	            						
	            					}
	            				}
	            			}
	            		}
	            	}
	            }
	            
	            for( int y1 =0 ; y1 <500 ; y1++)
	            {
	            	if(txtData1[y1] != "")
	            	{
	            		if(txtData1[y1].charAt(txtData1[y1].length() - 1) !='。')txtData1[y1] = txtData1[y1] + "。";
	            		//System.out.println(txtData1[y1]);
	            	}
	            	if(txtData2[y1] != "")
	            	{
	            		if(txtData2[y1].charAt(txtData2[y1].length() - 1) !='。')txtData2[y1] = txtData2[y1] + "。";
	            		//System.out.println(txtData2[y1]);
	            	}
	            }
	            
	            /*for( int y1 =0 ; y1 <500 ; y1++)
	            {
	            	if(txtData2[y1] != "")
	            	{
	            		if(txtData2[y1].charAt(txtData2[y1].length() - 1) !='。')txtData2[y1] = txtData2[y1] + "。";
	            		System.out.println(txtData2[y1]);
	            	}
	            }
	            */
	            System.out.println();
	            //----------------------------------------------------------
	            
	            
	            
	           /* FileWriter wfile = new FileWriter("C:\\Users\\mnuus\\Downloads\\研究関連\\kknp2\\"+list[j].getName());
	            PrintWriter pw = new PrintWriter(new BufferedWriter(wfile)); 
	            //かきこみ
	            
	            for(int i = 0 ; i < txtData.length  ; i++) {
	        		if(txtData[i] == null ||txtData[i] == "") break;
	        		System.out.println(txtData[i]);
	        	txtData[i] = txtData[i].replaceAll(kaigyo,"\n");
	        	txtData[i] = txtData[i] + "EOS";
	            pw.println(txtData[i]);
	            
	        	}
	            
	            
	             //最後にファイルを閉じてリソースを開放する
	            pw.close();
	           */
	            bufferedReader.close();
	            knpBufferedReader.close();
	         
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
		}
    
	}

}
