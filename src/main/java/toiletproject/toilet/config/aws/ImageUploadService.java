package toiletproject.toilet.config.aws;


import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@RequiredArgsConstructor
@Service
public class ImageUploadService {

    private final UploadService uploadService;

    public String uploadImage(MultipartFile file, String folder) {
        String fileName = folder + "/" + createFileName(file.getOriginalFilename());
        ObjectMetadata objectMetadata = new ObjectMetadata();
        objectMetadata.setContentLength(file.getSize());
        objectMetadata.setContentType(file.getContentType());
        try(InputStream inputStream = file.getInputStream()) {
            uploadService.uploadFile(inputStream, objectMetadata, fileName);
        } catch(IOException e) {
            throw new IllegalArgumentException(String.format("파일 변환 중 에러 발생 (%s)", file.getOriginalFilename()));
        }
        return uploadService.getFileUrl(fileName);
    }

    private String createFileName(String originalFileName) {
        return UUID.randomUUID().toString().concat(getFileExtension(originalFileName));
    }

    private String getFileExtension(String fileName) {
        try {
            return fileName.substring(fileName.lastIndexOf("."));
        } catch(StringIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format("잘못된 형식의 파일 입니다. (%s)", fileName));
        }
    }
}
