package com.mvcdao.org;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mvcdao.org.service.IUploadService;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class MvcDao3Application implements CommandLineRunner{
	
	@Autowired
	IUploadService uploadFileService;

	public static void main(String[] args) {
		SpringApplication.run(MvcDao3Application.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		uploadFileService.deleteAll();
		uploadFileService.init();
	}
	
}
