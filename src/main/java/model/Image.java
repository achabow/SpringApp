package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "IMAGE")
public class Image {

	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int image_id;
	private String file_name;
	private String file_description;
	private byte[] file_data;
	
	public int getId() {
		return image_id;
	}
	public void setId(int idImage) {
		this.image_id = idImage;
	}

	public String getFileName() {
		return file_name;
	}
	
	public void setFileName(String fileName) {
		this.file_name = fileName;
	}
	

	public String getFileDescription() {
		return file_description;
	}
	
	public void setFileDescription(String fileDescription) {
		this.file_description = fileDescription;
	}
	

	public byte[] getFileData() {
		return file_data;
	}
	
	public void setFileData(byte[] file_Data) {
		this.file_data = file_Data;
	}
	
	@Override
	public String toString(){
		return "id="+image_id+"name="+file_name+"description="+file_description;
	}
	
}
