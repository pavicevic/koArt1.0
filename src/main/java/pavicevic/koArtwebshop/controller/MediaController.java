package pavicevic.koArtwebshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pavicevic.koArtwebshop.dao.MediaDAO;
import pavicevic.koArtwebshop.service.MediaService;

import java.io.IOException;

@RequestMapping("/api/media")
@RestController
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping(value = "upload")
     public ResponseEntity<Void> upload(@RequestParam("fileContent") MultipartFile multipartFile ) throws IOException {
        mediaService.upload(multipartFile);
        return new ResponseEntity<>(HttpStatus.CREATED);
     }
     @GetMapping(value = "download/{id}")
    public ResponseEntity<?> download(@PathVariable Integer id) throws IOException {

         MediaDAO mediaDAO= mediaService.download(id);
         ByteArrayResource byteArrayResource= new ByteArrayResource(mediaDAO.getFileBytes());

         HttpHeaders httpHeaders= new HttpHeaders();
         httpHeaders.set("FILE-NAME", mediaDAO.getName());


        return new ResponseEntity<>(byteArrayResource,httpHeaders, HttpStatus.OK);
    }
}
