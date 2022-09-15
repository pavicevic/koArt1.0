package pavicevic.koArtwebshop.dao;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MediaDAO {

    private byte[] fileBytes;
    private String name;
}
