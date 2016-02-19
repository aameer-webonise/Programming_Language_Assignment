package pack;
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Reader{
//String line;

BufferedReader r;

public ArrayList<String> readFile(String fileName)
	{
	ArrayList<String> file= new ArrayList<String>();
	String line="";
	try{
		r=new BufferedReader(new FileReader(fileName));
		while((line=r.readLine())!=null)
		{
		file.add(line.replaceAll("\\s",""));
		}
		return file;
	}catch(Exception e){
		System.out.println(file);
		return null;	
	}
}


public ArrayList<String> findHotels(ArrayList<String> file,ArrayList<String> menu)
	{
		boolean done=true;
		int order_count=0;
			ArrayList<String>temp=new ArrayList<String>();
			for(String line:file)
			{
			  done=true;
			  StringTokenizer st=new StringTokenizer(line,",");
			  String id=st.nextToken();
			  String value=st.nextToken();
			  String order="";

			  while(st.hasMoreTokens())
			  {
				  order+=st.nextToken();
			  }

			  for(order_count=0;order_count<menu.size();order_count++){
			  if(order.contains(menu.get(order_count)))
			  {
				 
				if(temp.indexOf(line)==-1)
				{
					temp.add(line);
				}
			  }
			  else{
				  done=false;  
				  
			  }
			 
				
			  }
				 if(done&&menu.size()>1){
				 temp.add(line);
				 StringTokenizer s=new StringTokenizer(line,",");
				 int r_id=Integer.parseInt(s.nextToken());
				 double less_val=Double.parseDouble(s.nextToken());
				 System.out.println("=>>"+r_id+" "+less_val);
				 System.exit(0);
				}
				
			}
	
		return temp;

	}


public HashMap<Integer,Double> createMapList(ArrayList<String> file)
	{
		HashMap<Integer, Double> hotelID_sumValue_map = new HashMap<Integer, Double>();
		ArrayList<String>temp=new ArrayList<String>();
		boolean find=false;
		int id;
		double sum_value;
			while(!find)
			{
			temp=new ArrayList<String>();
			String w=file.get(0);
			StringTokenizer t=new StringTokenizer(w,",");
			id=Integer.parseInt(t.nextToken());
			sum_value=Double.parseDouble(t.nextToken());

				for(int index=1;index<file.size();index++)
				{
					w=file.get(index);
					t=new StringTokenizer(w,",");
					int r_id=Integer.parseInt(t.nextToken());
					if(id==r_id)
					{
						double unit_value=Double.parseDouble(t.nextToken());
						sum_value+=unit_value;
					}
					else
					{
						temp.add(file.get(index));
					}
					
				
				}
				hotelID_sumValue_map.put(id,sum_value);
				if(temp.isEmpty()||temp.size()==1)
				{
					find=true;
					continue;
				}
				file=temp;
				
			}
			
			return hotelID_sumValue_map;
	}


public boolean distributed(ArrayList<String> file,ArrayList<String> menu)
	{
		boolean done=false;
		boolean distributed=true;
		int order_count=0;
		int size=menu.size();

		for(String line:file)
			System.out.println(line);

		String line=file.get(0);		
		String firstLetter=Character.toString(line.charAt(0));
		
		for(int i=1;i<file.size();i++)
		{
			if(file.get(i).startsWith(firstLetter))
			{

				distributed=false;
				
				break;
			}
				
		}
		return distributed;
	}
}//class Reader
