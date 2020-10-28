package mas.ssatr.badiu.raluca;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PetrinetLoader {
	public ObjectualModel modelPetriNet() throws FileNotFoundException {
		 
		  Gson gson = new Gson();	   
		   BufferedReader br = new BufferedReader(
		     new FileReader("reteapetri.json"));
		   
		    //convert the json string back to object
		   ObjectualModel petriNet = gson.fromJson(br, ObjectualModel.class);
		   List listOfNodes = petriNet.getNoduri();
		   String start="";
		   for (int i = 0; i < listOfNodes.size(); i++) {
			  Nod n=(Nod) listOfNodes.get(i);
			  start=start+n.getNr_jetoane()+" ";
		   }
		   petriNet.setStart(start);		   
		   List listOfTr = petriNet.getTranzitii();
		   for (int i = 0; i < listOfTr.size(); i++) {
			Tranzitie n=(Tranzitie) listOfTr.get(i);
			n.setTimp(n.Random());
		    }
		  
		   
		  
		   
		  return petriNet;
		 }
}
