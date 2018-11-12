package com.mvcdao.org.service;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;
import java.io.IOException;
import java.net.MalformedURLException;

public interface IUploadService {

	public String copy(MultipartFile file) throws IOException;

	public Resource load(String filename) throws MalformedURLException;

	public void init() throws IOException;

	public void deleteAll();

}
