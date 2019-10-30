package cat.paucasesnovescifp.spaad.jaxb;

import cat.paucasesnovescifp.spaad.model.Film;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public abstract class Jaxb {

    public static Film llegirXml(String ruta) throws JAXBException {
        Film result = null;
        JAXBContext context = JAXBContext.newInstance(Film.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        result = (Film) unmarshaller.unmarshal(new File(ruta));
        return result;
    }
    
}
