import pack.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;
class FindRestaurant{
public static void main(String[] arg) {
		long t1=System.currentTimeMillis();
		Reader read=new Reader();
		boolean empty=false;
		ArrayList<String> file=read.readFile(arg[0]);
		ArrayList<String>menu=new ArrayList<String>();

		boolean find;

		int no_of_menu_item=arg.length;
		for(int i=1;i<no_of_menu_item;i++)
		{
		  menu.add(arg[i]);
		}
		//ArrayList<String>temp=new ArrayList<String>();
			
			file=read.findHotels(file,menu);
			if(file.isEmpty())
			{
				System.out.println("The Items You Entered is Not Available in Any Of The Restuarant");
			 	System.exit(0);
			}
			
			

			//code to check whether the item is distributed over multiple hotels
			if(menu.size()>1){
			boolean distributed=read.distributed(file,menu);
			if(distributed){
				System.out.println("Menu Is Distributed Over Multiple Hotels");
				System.out.println(System.currentTimeMillis()-t1);
				System.exit(0);
			}
			}
			System.out.println("Not Dist");
			

			HashMap<Integer, Double> hotelID_sumValue_map=read.createMapList(file);			
			Map.Entry<Integer, Double> min=null;
			for (Map.Entry<Integer,Double> entry : hotelID_sumValue_map.entrySet())
			{

			if (min==null || min.getValue()>entry.getValue()) {
			        min=entry;
			    }
 			 
			}
		
			System.out.println("=>"+min.getKey()+" "+min.getValue());
			System.out.println(System.currentTimeMillis()-t1);
		
}
}
