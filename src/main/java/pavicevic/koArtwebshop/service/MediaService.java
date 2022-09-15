package pavicevic.koArtwebshop.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pavicevic.koArtwebshop.dao.MediaDAO;
import pavicevic.koArtwebshop.entity.Media;
import pavicevic.koArtwebshop.repository.MediaRepository;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class MediaService {

    @Value("${fs.base-url}")
    private String baseFilePath;

   private final MediaRepository mediaRepository;



    public void upload(MultipartFile multipartFile) throws IOException {

        String originalFileName=new Date().getTime()+"_"+ multipartFile.getOriginalFilename();

        String fullPath= baseFilePath + originalFileName;
        Path path= Paths.get(fullPath);
        Files.write(path, multipartFile.getBytes());

        Media media= new Media();
        media.setName(multipartFile.getOriginalFilename());
        media.setFullPath(fullPath);

        mediaRepository.save(media);
    }
    public MediaDAO download(Integer id) throws IOException {
        Media media= mediaRepository
                .findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Media not found"));

        String fullPath= media.getFullPath();
        String fileName= media.getName();

        Path path= Paths.get(fullPath);
        byte[] fileBytes= Files.readAllBytes(path);
        return new MediaDAO(fileBytes,fileName);
    }
}
