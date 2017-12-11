package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import model.Image;

@Repository
public class ImageDAOImpl implements ImageDAO {

	private static final Logger logger = LoggerFactory.getLogger(ImageDAO.class);
	public SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	@Override
	public void addImage(Image img) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(img);
		logger.info("Image saved successfully, Image details= " + img);
	}
	
	@Override
	public void updateImage(Image img) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(img);
		logger.info("Image update successfully, Image details= " + img);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Image> listImages() {
		System.out.println("wchodzi do listy ??");
		Session session = this.sessionFactory.getCurrentSession();
		List<Image> imagesList = session.createQuery("from Image").list();
		for(Image img : imagesList){
			logger.info("Images list:: " + img);
		}
		return imagesList;
	}
	
	@Override
	public Image getImageById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Image img = (Image) session.load(Image.class, new Integer(id));
		logger.info("Image loaded successfully, Image details= " +img);
		return img;
	}
	
	@Override
	public void removeImage(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Image img = (Image) session.load(Image.class, new Integer(id));
		if (null != img){
			session.delete(img);
		}
	}
	
}