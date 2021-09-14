package turismoTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import tpTierraMedia.Atraccion;
import tpTierraMedia.Promocion;
import tpTierraMedia.TipoAtraccion;
import tpTierraMedia.TurismoTierraMedia;
import tpTierraMedia.Usuario;

public class TurismoTierraMediaTest {
   	
	TurismoTierraMedia ttm = new TurismoTierraMedia();
	
	Usuario user1 = new Usuario("Pedro", 1000, 1000, TipoAtraccion.AVENTURA);
	
	Atraccion atr1 = new Atraccion("Atraccion1", 10, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr2 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr3 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr4 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr5 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	
	ArrayList<Atraccion> Atracciones = new ArrayList<Atraccion>();
	ArrayList<Promocion> Promociones= new ArrayList<Promocion>();


	
	
	@Test
	public void generarArchivoTest() {
		
		Atracciones.add(atr1);
		Atracciones.add(atr2);
        Atracciones.add(atr3);
		Atracciones.add(atr4);
		Atracciones.add(atr5);

		user1.atraccionesAdquiridas= Atracciones;
		user1.promocionesAdquiridas= Promociones;
		ttm.generarArchivo(user1);
		//no hace nada pero era solo para probar que crea el archivo en la ruta especifica.
	}

}

