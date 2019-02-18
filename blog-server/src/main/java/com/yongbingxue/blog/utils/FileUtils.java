package com.yongbingxue.blog.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileUtils {
	private static final Logger logger = LogManager.getLogger(FileUtils.class);

	public static File generateTempFile(String fileType) {
		Path tmpPath = Paths.get("/tmp", UUID.randomUUID().toString() + "." + fileType);
		File tmpFile = tmpPath.toFile();
		logger.info("generateTempFile-tmpFile:{}", tmpFile);
		return tmpFile;
	}

	public static File generateTempFile() {
		Path tmpPath = Paths.get("/tmp", UUID.randomUUID().toString());
		File tmpFile = tmpPath.toFile();
		logger.info("generateTempFile-tmpFile:{}", tmpFile);
		return tmpFile;
	}

	public static File generateTempJpegFile() {
		Path tmpPath = Paths.get("/tmp", UUID.randomUUID().toString() + ".jpeg");
		File tmpFile = tmpPath.toFile();
		logger.info("generateTempJpegFile-tmpFile:{}", tmpFile);
		return tmpFile;
	}

	public static void close(InputStream inputstream) {
		if (inputstream == null) {
			return;
		}
		try {
			inputstream.close();
		} catch (IOException e) {
			logger.error(e);
		}
	}
}
