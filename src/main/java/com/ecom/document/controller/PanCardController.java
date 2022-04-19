package com.ecom.document.controller;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ecom.document.entity.PanCardRespMassage;
import com.ecom.document.entity.PanCardResponseFile;
import com.ecom.document.service.PanCardStorageService;

@RestController
public class PanCardController {

	@Autowired
	private PanCardStorageService cardService;

	@PostMapping("/file")
	public ResponseEntity<PanCardRespMassage> uploadPanCard(@RequestParam("file") MultipartFile file) {
		String message = "";

		try {
			cardService.storePanCard(file);
			message = "File IS Upload Succesfully: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(new PanCardRespMassage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new PanCardRespMassage(message));
		}
	}

	@GetMapping("/files")
	public ResponseEntity<List<PanCardResponseFile>> getPanCardList() {
		List<PanCardResponseFile> files = cardService.getAllFiles().map(panCardFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/file")
					.path(panCardFile.getId()).toUriString();
			return new PanCardResponseFile(panCardFile.getPanName(), fileDownloadUri, panCardFile.getPanCardNo());
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}

}