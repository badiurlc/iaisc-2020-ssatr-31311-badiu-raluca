package mas.ssatr.badiu.raluca;

import java.util.List;

public class ObjectualModel {
	private List<Nod> noduri=null;
	private List<Tranzitie> tranzitii =null;
	private String start;
	private String curent;
	private int verificareDeadlock=0;

	public List<Nod> getNoduri() {
		return noduri;
	}

	public void setNoduri(List<Nod> noduri) {
		this.noduri = noduri;
	}

	public List<Tranzitie> getTranzitii() {
		return tranzitii;
	}


	public void setTranzitii(List<Tranzitie> tranzitii) {
		this.tranzitii = tranzitii;
	}


	public String getStart() {
		return start;
	}


	public void setStart(String start) {
		this.start = start;
	}



	public String getCurent() {
		return curent;
	}



	public void setCurent(String curent) {
		this.curent = curent;
	}



	public int getVerificareDeadlock() {
		return verificareDeadlock;
	}



	public void setVerificareDeadlock(int verificareDeadlock) {
		this.verificareDeadlock = verificareDeadlock;
	}
	
	public String afisareMarcaj() {
			String marcaj="";
		   	for (int i = 0; i < noduri.size(); i++) {
			Nod n=(Nod) noduri.get(i);
		    marcaj=marcaj+n.getNr_jetoane()+" ";
		   }
		System.out.println();
		setCurent(marcaj);
		return marcaj;
	}
	
	public Nod cautareNod(ObjectualModel model,String input_tranzitie) {
		Nod n=null;
		for(int i=0;i<noduri.size();i++) {
			
			if(noduri.get(i).getNume().equals(input_tranzitie)) {
				n=noduri.get(i);
			}
		}		
		return n;
	}
	

}