package mas.ssatr.badiu.raluca;

public class Tranzitie {
private String nume;
private String[] inputs;
private String[] outputs;
private int min;
private int max;
private int timp=0;
private boolean asteptare=false;

public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String[] getInputs() {
	return inputs;
}
public void setInputs(String[] inputs) {
	this.inputs = inputs;
}
public String[] getOutputs() {
	return outputs;
}
public void setOutputs(String[] outputs) {
	this.outputs = outputs;
}
public int getMin() {
	return min;
}
public void setMin(int min) {
	this.min = min;
}
public int getMax() {
	return max;
}
public void setMax(int max) {
	this.max = max;
}
public int getTimp() {
	return timp;
}
public void setTimp(int timp) {
	this.timp = timp;
}
public boolean getAsteptare() {
	return asteptare;
}
public void setAsteptare(boolean asteptare) {
	this.asteptare = asteptare;
}
public int Random() {
    if (min == max) {
        return max;
    } else {
        return (min + (int) (Math.random() * ((max - min) + 1)));
    }
}

}
