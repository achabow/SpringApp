package service;

import java.util.List;
import model.Image;

public interface ImageService {

	public void addImage(Image img);
	public void updateImage(Image img);
	public List<Image> listImages();
	public Image getImageById(int id);
	public void removeImage(int id);
	
}
