package mas.ssatr.badiu.raluca;

import java.io.FileNotFoundException;
import java.util.List;

public class SimulationEngine {
	
	private int clock;
	private boolean active = true;
	
	
	void simulate(ObjectualModel model){
		ScriereFisier.writeToFile("");
		while(active) {
			if(clock==0) {
				ScriereFisier.writeToFile("Marcajul initial "+model.getStart());
				System.out.println("Marcajul initial "+model.getStart());
			}
			ScriereFisier.writeToFile("Timpul "+clock+":");
			System.out.println("Timpul "+clock+":");
			active=evaluate(model, clock);
			clock++;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   }
	}
	
	boolean evaluate(ObjectualModel model,int clock) {
			
			boolean executabila;
			model.setVerificareDeadlock(0);
		   List listOfTr = model.getTranzitii();
		   for (int i = 0; i < listOfTr.size(); i++) {
			   executabila=true;
			Tranzitie t=(Tranzitie) listOfTr.get(i);
			//System.out.print(t.getNume()+" ");
			String[] inputs=t.getInputs();
		    String[] outputs=t.getOutputs();
		    if(t.getAsteptare()==true&&t.getTimp()>0) {
		    	t.setTimp(t.getTimp()-1);
		    }
		    Nod nod=null;
		    Nod nod_urm=null;	
		    for(int j=0; j<inputs.length;j++) {
		    	nod=model.cautareNod(model, inputs[j]);
		    	if(nod.getNr_jetoane()==0) {
		    		executabila=false;
		    		//System.out.println("tranzitia "+t.getNume()+" nu e executabila");
		    	}		    			    			    	
		    }		    
		    if(executabila==true||t.getAsteptare()==true) {
		    	//System.out.println(t.getNume());
		    	if(t.getAsteptare()==false) {
		    	for(int j=0; j<inputs.length;j++) {
		    	nod=model.cautareNod(model, inputs[j]);
		    	nod.setNr_jetoane(nod.getNr_jetoane()-1);
		    	ScriereFisier.writeToFile("S-a luat jeton din "+nod.getNume());
		    	System.out.println("S-a luat jeton din "+nod.getNume());
		    	}
		    	}
		    	if(t.getTimp()>0) {	
		    		t.setAsteptare(true);
		    		ScriereFisier.writeToFile(t.getNume()+" in asteptare");
		    		System.out.println(t.getNume()+" in asteptare");
		    		
			    	}
		    	if(t.getAsteptare()==true&&t.getTimp()==0)
		    		t.setAsteptare(false);
		    	if(t.getAsteptare()==false){
		    		for(int j=0;j<outputs.length;j++) {
		    		nod_urm=model.cautareNod(model,outputs[j]);
		    		nod_urm.setNr_jetoane(nod_urm.getNr_jetoane()+1);
		    		ScriereFisier.writeToFile("Jetonul trece din tranzitia "+t.getNume()+" in "+nod_urm.getNume());
		    		System.out.println("Jetonul trece din tranzitia "+t.getNume()+" in "+nod_urm.getNume());
		    		}
		    			    	
			    }
		    	
		    	}
	    		
		    else
		    {	
		    	model.setVerificareDeadlock(model.getVerificareDeadlock()+1);
		    }
	    	
		    	    
		   }
		if(clock>0) {
		ScriereFisier.writeToFile("Marcajul la timpul "+clock+": "+model.afisareMarcaj());
		System.out.println("Marcajul la timpul "+clock+": "+model.afisareMarcaj());   
		}
		if(model.getVerificareDeadlock()==model.getTranzitii().size()) {
			ScriereFisier.writeToFile("Deadlock");
			System.out.println("Deadlock");
			return false;	
		}
		if(model.getCurent()==model.getStart()) {
			ScriereFisier.writeToFile("Reteaua Petri se repeta");
			System.out.println("Reteaua Petri se repeta");
			return false;
		}
		return true;
	}
	
	public static void main(String []args) throws FileNotFoundException {
		ScriereFisier.writeToFile("");
		PetrinetLoader p=new PetrinetLoader();
		ObjectualModel m=p.modelPetriNet();
		SimulationEngine e=new SimulationEngine();
		e.simulate(m);
		ScriereFisier.closeFile();
	}
	
}
