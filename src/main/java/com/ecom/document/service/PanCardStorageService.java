package com.ecom.document.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ecom.document.entity.PanCardFile;
import com.ecom.document.repository.PanCardRespository;
@Service
public class PanCardStorageService {

	@Autowired
	private PanCardRespository cardRepository;
	
	public PanCardFile storePanCard(MultipartFile file) throws IOException {
		String panFileName= StringUtils.cleanPath(file.getOriginalFilename());
		PanCardFile cardFile= new PanCardFile(panFileName, file.getContentType(), panFileName, panFileName, panFileName, panFileName, file.getBytes());
	return cardRepository.save(cardFile);
	
	}
	public PanCardFile getfiles(String id) {
		return cardRepository.getById(id);
	}
	public Stream<PanCardFile> getAllFiles() {
		return cardRepository.findAll().stream();
	}
}
