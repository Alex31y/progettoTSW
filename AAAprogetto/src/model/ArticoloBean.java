package model;

public class ArticoloBean {
	public ArticoloBean() {
		setId(-1);
		setNome("default");
		setDescrizione("default");
		setPezzi(0);
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getPezzi() {
		return pezzi;
	}
	
	public void setPezzi(int amount) {
		this.pezzi = amount;
	}

	public void incremPezzi() {
		this.pezzi = this.getPezzi()+1;
	}

	private int id, pezzi;
	private float prezzo;
	private String nome, descrizione, img;
}
