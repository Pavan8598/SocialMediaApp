package com.socialmedia.app.entities;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class multimedia{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;

   public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public byte[] getData() {
	return data;
}

public void setData(byte[] data) {
	this.data = data;
}

@Column(unique = true)
   private String name;

   @Lob
   private byte[] data;

   public multimedia(String name, byte[] data) {
       this.name = name;
       this.data = data;
   }
   public multimedia()
   {
	   
   }
}