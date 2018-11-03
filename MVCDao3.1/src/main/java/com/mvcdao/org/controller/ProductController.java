package com.mvcdao.org.controller;

import java.io.OutputStream;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcdao.org.models.Product;
import com.mvcdao.org.models.ProductModel;
import com.mvcdao.org.models.Producto;
import com.mvcdao.org.service.IProductoService;
import com.mvcdao.org.service.IUploadService;
import com.mvcdao.org.util.ZXingHelper;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Controller
@RequestMapping(value = { "product" })
public class ProductController {

	@Autowired
	private IProductoService productoService;

	@Autowired
	private IUploadService uploadService;

	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap modelMap) {

		ProductModel productModel = new ProductModel();
		modelMap.put("products", productModel.findAll());
		return "product/index";
	}

	@RequestMapping(value = "barcode/{id}", method = RequestMethod.GET)
	public void barcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {

		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getBarCodeImage(id, 2000, 200));
		outputStream.flush();
		outputStream.close();
	}

	@RequestMapping(value = "addproduct", method = RequestMethod.GET)
	public ModelAndView addProduct(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mav = new ModelAndView("product/addproduct");
		mav.addObject("newProducto", new Producto());
		return mav;
	}

	@RequestMapping(value = "/addproduct", method = RequestMethod.POST)
	public ModelAndView registerProduct(HttpServletRequest request, HttpServletResponse response,
			@ModelAttribute("newProducto") Producto newProducto, @RequestParam("file") MultipartFile foto) {

		ModelAndView mav = new ModelAndView("product/addproduct");
		System.out.println(newProducto);
		
		if (!foto.isEmpty()) {
			String uniqueFilename = null;
			try {
				uniqueFilename = uploadService.copy(foto);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("Has subido correctamente '" + uniqueFilename + "'");	
			newProducto.setFoto(uniqueFilename);
		}
		
		
		productoService.save(newProducto);
		return mav;
	}

}