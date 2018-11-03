package com.mvcdao.org.service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;

public interface IUploadService {
	public String copy(MultipartFile file) throws IOException;

	public void init() throws IOException;

	public void deleteAll();

}
