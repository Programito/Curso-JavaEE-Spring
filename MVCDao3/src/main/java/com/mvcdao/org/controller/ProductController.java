package com.mvcdao.org.controller;

import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mvcdao.org.models.ProductModel;
import com.mvcdao.org.util.ZXingHelper;


@Controller
@RequestMapping(value = {"product"})
public class ProductController {

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

}