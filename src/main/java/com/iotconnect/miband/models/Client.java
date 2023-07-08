package com.iotconnect.miband.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "client")
public class Client {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @Column(unique=true)
	private String mac;
	
	@NotNull
	private String nom;
	
	private String prenom;
	
	private String tel;
	
	private String adresse;
	
	private String mail;

	private String blood;

	private String sex;

	private int age;

	private double weight;
	
	@JsonIgnore
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL, orphanRemoval = true , fetch = FetchType.LAZY )
	private List<Heartbeat> heartbeats = new ArrayList<>();
	
	public void addHeartbeat(Heartbeat heartbeat) {
		heartbeats.add(heartbeat);
		heartbeat.setClient(this);
    }
 
    public void removeHeartbeat(Heartbeat heartbeat) {
    	heartbeats.remove(heartbeat);
    	heartbeat.setClient(null);
    }
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getBlood() {
		return blood;
	}

	public void setBlood(String blood) {
		this.blood = blood;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "id : " +id+" , nom : " + nom + " , prenom : " + prenom + " , mac : " + mac;
	}
	
	@Override
	public int hashCode() {
		return 31 + mac.hashCode() + id.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
	        return true;
	    if (!(o instanceof Client))
	        return false;
	    Client other = (Client)o;
	    boolean clientCodeEquals = (this.mac == null && other.mac== null) || (this.mac != null && this.mac.equals(other.mac)) ;
	    return this.id.equals(other.id) && clientCodeEquals ;
	}

	public List<Heartbeat> getHeartbeats() {
		return heartbeats;
	}

	public void setHeartbeats(List<Heartbeat> heartbeats) {
		this.heartbeats = heartbeats;
	}

}
