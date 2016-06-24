package com.daykm.domain;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Weapon")
public class Weapon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@OneToMany(fetch = FetchType.EAGER, mappedBy="id")
	private Set<WeaponAttributes> attrs;
	@Column(name="name")
	private String name;
	
	public Weapon() {
		attrs = new HashSet<WeaponAttributes>();
		for(int i = 0; i < 4; i++) {
			attrs.add(new WeaponAttributes());
		}
	}
	
	
	public Set<WeaponAttributes> getAttrs() {
		return attrs;
	}
	public void setAttrs(Set<WeaponAttributes> attrs) {
		this.attrs = attrs;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
