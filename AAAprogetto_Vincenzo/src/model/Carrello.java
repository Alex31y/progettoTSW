package model;

import java.util.*;

public class Carrello {
	
	private List<ArticoloBean> elementi;
	
	public Carrello() {
		elementi = new ArrayList<ArticoloBean>();
		setAmount(0);
		setNumeroElementi(0);
	}
	
	public void addArticolo(ArticoloBean elem) {
		this.numeroElementi++;
		this.amount = this.amount + elem.getPrezzo();
		
		boolean contains = false;
		int index = 0;
		Iterator<ArticoloBean> it = elementi.iterator();
		while(it.hasNext()) {
			ArticoloBean el = it.next();
			if(el.getId() == elem.getId()) {
				contains = true;
				index = elementi.indexOf(el);
			}
		}
		if(contains) {
			elementi.get(index).incremPezzi();
		}
		else {
			elementi.add(elem);
			elem.setPezzi(1);
		}
	}
	
	public void removeArticolo(ArticoloBean elem) {
		int index = 0;
		Iterator<ArticoloBean> it = elementi.iterator();
		while(it.hasNext()) {
			ArticoloBean el = it.next();
			if(el.getId() == elem.getId()) {
				index = elementi.indexOf(el);
			}
		}
		this.amount = this.amount - elementi.get(index).getPezzi() * elementi.get(index).getPrezzo();
		this.numeroElementi = this.numeroElementi - elementi.get(index).getPezzi();
		elementi.remove(index);
	}
	
	public List<ArticoloBean> getArticoli(){
		return elementi;
	}
	
	public void setPezziArticolo(int id, int pezzi) {
		int index = 0;
		Iterator<ArticoloBean> it = elementi.iterator();
		while(it.hasNext()) {
			ArticoloBean el = it.next();
			if(el.getId() == id) {
				elementi.get(index).setPezzi(pezzi);
				calcolAmount();
				calcolaNumeroElementi();
			}
			index++;
		}
	}
	
	public void calcolAmount() {
		this.amount = 0;
		Iterator<ArticoloBean> it = elementi.iterator();
		ArticoloBean el;
		while(it.hasNext()) {
			el = it.next();
			this.amount = this.amount + el.getPrezzo() * el.getPezzi();
		}
	}
	
	public void calcolaNumeroElementi() {
		this.numeroElementi = 0;
		Iterator<ArticoloBean> it = elementi.iterator();
		ArticoloBean el;
		while(it.hasNext()) {
			el = it.next();
			this.numeroElementi = this.numeroElementi + el.getPezzi();
		}
	}
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public void aggiungiPrezzo(double prz) {
		this.amount = this.amount + prz;
	}


	public int getNumeroElementi() {
		return numeroElementi;
	}

	public void setNumeroElementi(int numeriElementi) {
		this.numeroElementi = numeriElementi;
	}
	

	private int numeroElementi;
	private double amount;
}
