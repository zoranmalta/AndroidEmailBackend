package com.example.AndroidEmailBackend.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.AndroidEmailBackend.model.Attachment;
import com.example.AndroidEmailBackend.repository.AttachmentRepository;
import com.example.AndroidEmailBackend.service.IAttachmentService;

@Service
public class AttachmentService implements IAttachmentService  {

	@Autowired
	AttachmentRepository attachmentRepository;

	@Override
	public List<Attachment> getAttachmentsForMessage(Long id) {
		
		return attachmentRepository.findByMessage_id(id);
	}
}
