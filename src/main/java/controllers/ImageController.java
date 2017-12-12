package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



import model.Image;
import service.ImageService;

@Controller
public class ImageController {

	private ImageService imageService;
	
	@Autowired
	@Qualifier(value="imageService")
	public void setImageService(ImageService img){
		this.imageService = img;
	}
	
	@RequestMapping(value="/images", method = RequestMethod.GET)
	public String listImages(Model model){
		model.addAttribute("image", new Image());
		model.addAttribute("listImages", this.imageService.listImages());
		return "image";
	}
	
	@RequestMapping(value="/image/add", method = RequestMethod.POST)
	public String addImage(@ModelAttribute("image")Image img){
		if(img.getId() == 0) {
			this.imageService.addImage(img);
		} else {
			this.imageService.updateImage(img);
		}
		return "redirect:/images";
	}
	
	@RequestMapping(value= "remove/image/{image_id}")
	public String removeImage(@PathVariable("image_id") int id){
		this.imageService.removeImage(id);
		return "redirect:/images";
	}
	
	@RequestMapping(value= "edit/image/{image_id}")
	public String editImage(@PathVariable("image_id") int id, Model model){
		model.addAttribute("image", this.imageService.getImageById(id));
		model.addAttribute("listimage", this.imageService.listImages());
		return "image";
	}
}
