package com.example.AndroidEmailBackend.service;

import java.util.List;

import com.example.AndroidEmailBackend.model.Attachment;

public interface IAttachmentService {

	List<Attachment> getAttachmentsForMessage(Long id);
}
