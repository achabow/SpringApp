package service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import dao.ImageDAO;
import model.Image;

public class ImageServiceImpl implements ImageService {

	private ImageDAO imageDAO;
	
	public void setImageDAO(ImageDAO imageDAO){
		this.imageDAO = imageDAO;
	}
	
	@Override
	@Transactional
	public void addImage(Image img) {
		this.imageDAO.addImage(img);
	}

	@Override
	@Transactional
	public void updateImage(Image img) {
		this.imageDAO.updateImage(img);
	}

	@Override
	@Transactional
	public List<Image> listImages() {
		return this.imageDAO.listImages();
	}

	@Override
	@Transactional
	public Image getImageById(int id) {
		return this.imageDAO.getImageById(id);
	}

	@Override
	@Transactional
	public void removeImage(int id) {
		this.imageDAO.removeImage(id);
	}

}
