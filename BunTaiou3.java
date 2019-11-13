import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


class kouzou
{
	int num =0;
	String word = "";
}
public class BunTaiou3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("はじまり");
		File dir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\文文節語\\k1");
		File[] list = dir.listFiles();
		File knpdir = new File("C:\\Users\\mnuus\\Downloads\\研究関連\\文文節語\\knptab");
		File[] knplist= knpdir.listFiles();
		

		for(int j = 0 ;j < list.length; j++)
		{
			double[][] Itti = new double[5000][5000];
			String[] txtData1 = new String[500];
			String[] txtData2 = new String[500];
			String[] preKnpData1 = new String[5000];
			String[] preKnpData2 = new String[5000];
			String[][] knpData1 = new String[500][500];
			String[][] knpData2 = new String[500][500];
			String[][] kakariData1 = new String[500][500];
			String[][] kakariData2 = new String[500][500];
			kouzou[] kouzou1 = new kouzou[5000];
			kouzou[] kouzou2 = new kouzou[5000];
			int[] bunsetuInd1 = new int[50];
			int[] bunsetuInd2 = new int[50];
			int[] kakariInd1 = new int[50];
			int[] kakariInd2 = new int[50];

			int[][] pareCount = new int[50][50];
			String BIN1 ="";
        	String BIN2 ="";
			for(int a = 0 ;a <50 ;a++)
			{
				 bunsetuInd1[a] = 0 ;
				 bunsetuInd2[a] = 0 ;
				 kakariInd1[a] = 0;
				 kakariInd2[a] = 0;
				 for(int a1 = 0 ;a1 <50 ;a1++)
					{
						pareCount[a][a1] = 0;
					}
			}
			for(int a = 0 ;a <5000 ;a++)
			{
				
				preKnpData1[a] = "";
				preKnpData2[a] = "";
				for(int b = 0; b < 5000 ; b++)
				{
					Itti[a][b] = 0;
				}
			}
			for(int a = 0 ;a <500 ;a++)
			{
				txtData1[a] = "";
				txtData2[a] = "";
			

				for(int b = 0; b < 500 ; b++)
				{
					Itti[a][b] = 0;
					knpData1[a][b] = "";
					knpData2[a][b] = "";
					kakariData1[a][b] = "";
					kakariData2[a][b] = "";
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
	            int kind2 = 0;
	            
	            int io = 0;
	            
	            while ((knpData = knpBufferedReader.readLine()) != null) {
	            	//System.out.println(knpData);
	            	if(knpData.charAt(0) == 'P' &&knpData.charAt(1) == 'E' && knpData.charAt(2) == 'O' && knpData.charAt(3) == 'S' )io =1;
	            	else if(knpData.charAt(0) == 'E' && knpData.charAt(1) == 'O' && knpData.charAt(2) == 'S' && io == 1)io =2;
	            	else if(io == 0)
	            	{
	            		preKnpData1[kind1] = knpData;
	            		kind1++;
	            		//System.out.println(io +knpData);
	            	}
	            	else if(io == 2)
	            	{
	            		//System.out.println(io + knpData);
	            		preKnpData2[kind2] = knpData;
	            		kind2++;
	            	}
	            }
	            int kouzouind1 = -1;
	            int kouzouind2 = -1;
	            String s ="";
	           
	            for(int j1 = 0; j1 < kind1 ; j1++)
	            {
	            	System.out.println(preKnpData1[j1].charAt(0));
	            	if(preKnpData1[j1].charAt(0) =='*') 
	            	{
	            		
	            		if(kouzouind1 != -1)
	            		{
	            			System.out.println(s+"かかり先は"+kouzou1[kouzouind1].num);
	            			kouzou1[kouzouind1].word = s;
	            			s ="";
	            		}
	            		kouzouind1++;
	            		kouzou1[kouzouind1].num = preKnpData1[j1].charAt(2);
	            	}
	            	if(preKnpData1[j1].charAt(0) !='?' &&preKnpData1[j1].charAt(0) !='+')
	            	{
	            		int g=0;
	            		while(preKnpData1[j1].charAt(g) != ' ')
	            		{
	            			s = s + preKnpData1[j1].charAt(g);
	            		}
	            	}
	            }
	            

	        	
	           
	            

	            //↑で文節のデータをknpData1とknpData2に入れることができた。
	          
	            //↓文節でどれくらい対応するか。
	            int r1 = 0;//記事Aに何文あるか
	            int r2 = 0;//記事Bに何文あるか
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
	            	bunsetuInd1[h] = g;//index番目の文に何個文節があるか。
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
	            	bunsetuInd2[h] = g;//h文目にg個の文節がある
	            }

	            //------------------------
	            //↓係り受けがどれだけ対応するか
	            int t1 = 0;//記事Aに何文あるか
	            int t2 = 0;//記事Bに何文あるか
	            
	            while(kakariData1[t1][0] != "")
	            {
	            	t1++;
	            }
	            for(int h = 0; h < t1 ;h++)
	            {
	            	int g = 0;
	            	while(kakariData1[h][g] != "")
	            	{
	            		g++;
	            	}
	            	kakariInd1[h] = g;//index番目の文に何個ペアがあるか。
	            }

	            while(kakariData2[t2][0] != "")
	            {
	            	t2++;
	            }
	            for(int h = 0; h < t2 ;h++)
	            {
	            	int g = 0;
	            	while(kakariData2[h][g] != "")
	            	{
	            		g++;
	            	}
	            	kakariInd2[h] = g;//h文目にg個のペアがある
	            }
	            
	           
	            
	            int binary1 = (int)Math.pow(2, t1) ;
	            int binary2 = (int)Math.pow(2, t2) ;
	            
	            
	            for(int m1 = 0; m1 < binary1 ; m1++) 
	            {
	            	for(int m2 = 0; m2 < binary2 ; m2++) 
		            {
		            	String bin1 = Integer.toBinaryString(m1);
		            	String bin2 = Integer.toBinaryString(m2);
		            	while(bin1.length() != t1  )
		            	{
		            		bin1 = "0"+ bin1 ;
		            	}
		            	while(bin2.length() != t2  )
		            	{
		            		bin2 = "0"+ bin2 ;
		            	}
		            	
		            	String[] s1 = new String[500] ; 
		            	String[] s2 = new String[500] ; 
		            	String[] sb1 = new String[500] ; //バイナリーで一致する文節を入れる
		            	String[] sb2 = new String[500] ; //バイナリーで一致する文節を入れる
		            	int ind1 = 0;
		            	int ind2 = 0;
		            	int indb1 = 0;
		            	int indb2 = 0;
		            	int ittiNum = 0;
		            	int ittiBunsetu = 0;
		            	
		            	double score = 0;
		            	
		            	
		            	//-------------↓ここからバイナリーで一致する文を一つにまとめる
		            	
		            	for(int j1 = 0; j1 < t1 ;j1++)//t1は文の数
		            	{
		            		if(bin1.charAt(j1) == '1')
		            		{
		            			
		            			for(int h1 = 0; h1 < kakariInd1[h1] ;h1++)
		            			{
		            				s1[ind1] = kakariData1[j1][h1];
		            				ind1++;
		            			}
		            			for(int h1 = 0; h1 < bunsetuInd1[h1] ;h1++)
		            			{
		            				sb1[indb1] = kakariData1[j1][h1];
		            				indb1++;
		            			}
		            			
		            		}
		            	}
		            	
		            	for(int j2 = 0; j2 < t2 ;j2++)//t1は文の数
		            	{
		            		
		            		if(bin2.charAt(j2) == '1')
		            		{
		            			
		            			for(int h2 = 0; h2 < kakariInd2[h2] ;h2++)
		            			{
		            				s2[ind2] = kakariData2[j2][h2];
		            				ind2++;
		            			}
		            			for(int h2 = 0; h2 < bunsetuInd2[h2] ;h2++)
		            			{
		            				sb2[indb2] = kakariData1[j2][h2];
		            				indb2++;
		            			}
		            		}
		            	}
		            	
		            	//-------------------------↑バイナリーで一致する文を一つにまとめた
		            	for(int j1 = 0; j1 < ind1 ; j1++)
		            	{
		            		for(int j2 = 0; j2 < ind2 ; j2++)
			            	{
		            			if(s1[j1].length() == s2[j2].length())
		            			{
		            				int hantei = 0;
		            				for (int g = 0 ; g < s1[j1].length(); g++)
									{
										if(s1[j1].charAt(g) == s2[j2].charAt(g))hantei++;
									}
		            			
									if(hantei == s1[j1].length())
									{
										ittiNum++;
									}
		            			}
			            	}
		            	}
		            	
		            	for(int j1 = 0; j1 < indb1 ; j1++)
		            	{
		            		for(int j2 = 0; j2 < indb2 ; j2++)
			            	{
		            			if(sb1[j1].length() == sb2[j2].length())
		            			{
		            				int hantei = 0;
		            				for (int g = 0 ; g < sb1[j1].length(); g++)
									{
										if(sb1[j1].charAt(g) == sb2[j2].charAt(g))hantei++;
									}
		            			
									if(hantei == sb1[j1].length())
									{
										ittiBunsetu++;
									}
		            			}
			            	}
		            	}
		            	
		            	
		            	
		            	if(ind1 == 0 || ind2 == 0)
		            	{
		            		Itti[binary1][binary2] = -1;
		            	}
		            	
		            	
		            	else 
		            	{
		            		//Itti[binary1][binary2] = (double)ittiNum / (double)ind1;
		            		if((double)ittiNum / (double)ind1 > 0.5 && (double)ittiNum / (double)ind2 > 0.5 &&
		            				(double)ittiNum / (double)ind1 < 3 && (double)ittiNum / (double)ind2 < 3 &&
		            				(double)ittiBunsetu  > (double)indb1 * 0.4 && (double)ittiBunsetu  > (double)indb2  * 0.4
		            				
		            				) {
		            			for(int j1 = 0; j1 < t1 ;j1++)//t1は文の数
				            	{
				            		
				            		if(bin1.charAt(j1) == '1')
				            		{
				            			for(int z = 0; z < bunsetuInd1[j1] ;z++)
				            			{
				            				//System.out.print(knpData1[j1][z]);
				            			}
				            			//System.out.println();
				            		}
				            		
				            	}
		            			//System.out.println("-----------------------------------------");
		            			for(int j2 = 0; j2 < t2 ;j2++)//t1は文の数
				            	{
				            		
				            		if(bin2.charAt(j2) == '1')
				            		{
				            			for(int z = 0; z < bunsetuInd2[j2] ;z++)
				            			{
				            				//System.out.print(knpData2[j2][z]);
				            			}
				            			//System.out.println();
				            		}
				            		
				            	}
			            		//System.out.println(binary1);
			            		//System.out.println(binary2);
			            		//System.out.println((double)ittiNum / (double)ind1+"と"+(double)ittiNum / (double)ind2);
			            		//System.out.println("文節は"+(double)ittiBunsetu / (double)indb1 +"と"+ (double)ittiBunsetu / (double)indb2);
		            		}
		            	
		            	}
		            	int g1 = 0;
		            	int g2 = 0;
		            	for(int j1 = 0; j1 < t1 ;j1++)//t1は文の数
		            	{
		            		if(bin1.charAt(j1) == '1')
		            		{
		            			g1++;
		            		}
		            	}
		            	
		            	for(int j2 = 0; j2 < t2 ;j2++)//t1は文の数
		            	{
		            		
		            		if(bin2.charAt(j2) == '1')
		            		{
		            			g2++;
		            		}
		            	}
		            	if(score < ((double)ittiNum / (double)ind1)+((double)ittiNum / (double)ind2) + ((double)ittiBunsetu / (double)indb1) + ((double)ittiBunsetu / (double)indb2)
		            			&& g1 < 3 && g2 < 3)
		            	{
		            		score = ((double)ittiNum / (double)ind1)+((double)ittiNum / (double)ind2) + ((double)ittiBunsetu / (double)indb1) + ((double)ittiBunsetu / (double)indb2);
		            		BIN1 = bin1;
			            	BIN2 = bin2;
		            	}
		            }
	            	
	            }
	            
	            if(BIN1 != "" &&BIN2 !="")
	            {
		            for(int j1 = 0; j1 < t1 ;j1++)//t1は文の数
	            	{
	            		if(BIN1.charAt(j1) == '1')
	            		{
	            			for(int h1 = 0; h1 < bunsetuInd1[j1] ;h1++)
	            			{
	            				System.out.print(knpData1[j1][h1]);
	            			}
	            			System.out.println("");
	            		}
	            	}
	            	System.out.println("----------------------------------------------");
	            	for(int j2 = 0; j2 < t2 ;j2++)//t1は文の数
	            	{
	            		
	            		if(BIN2.charAt(j2) == '1')
	            		{
	            			
	            			
	            			for(int h2 = 0; h2 < bunsetuInd2[j2] ;h2++)
	            			{
	            				System.out.print(knpData2[j2][h2]);
	            			}
	            			System.out.println("");
	            		}
	            	}
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


	            //----------------------------↓融合結果表示

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
System.out.println("おわり");
	}

}
