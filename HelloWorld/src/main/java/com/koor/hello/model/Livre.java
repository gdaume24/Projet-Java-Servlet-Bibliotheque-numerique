package com.koor.hello.model;


public class Livre {
	private int id;
	private String titre;
	private String auteur;
	private String isbn;
	private int anneePublication;
	private String genre;
	
	public Livre(String titre, String auteur, String ISBN, int annee_de_publication, String genre) {
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setIsbn(ISBN);
		this.setAnneePublication(annee_de_publication);
		this.setGenre(genre); 
	}
	
	public Livre(int id, String titre, String auteur, String ISBN, int annee_de_publication, String genre) {
		this.setId(id);
		this.setTitre(titre);
		this.setAuteur(auteur);
		this.setIsbn(ISBN);
		this.setAnneePublication(annee_de_publication);
		this.setGenre(genre);
	}
	
	@Override
	public String toString() {
	    StringBuilder sb = new StringBuilder();

	    if (id != 0) {
	        sb.append("ID : ").append(id).append("\n");
	    }

	    sb.append("Titre : ").append(titre).append("\n")
	      .append("Auteur : ").append(auteur).append("\n")
	      .append("ISBN : ").append(isbn).append("\n")
	      .append("Année de publication : ").append(anneePublication).append("\n")
	      .append("Genre : ").append(genre);

	    return sb.toString();
	}

	
	public String getTitre() {
		return this.titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String ISBN) {
		this.isbn = ISBN;
	}

	public int getAnneePublication() {
		return anneePublication;
	}

	public void setAnneePublication(int annee_de_publication) {
		this.anneePublication = annee_de_publication;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
