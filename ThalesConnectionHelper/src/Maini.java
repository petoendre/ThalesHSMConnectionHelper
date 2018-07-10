import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import com.ncipher.km.marshall.NFKM_SoftCard;
import com.ncipher.km.nfkm.CreateSoftCard;
import com.ncipher.km.nfkm.Key;
import com.ncipher.km.nfkm.SecurityWorld;
import com.ncipher.km.nfkm.SoftCard;
import com.ncipher.nfast.NFException;
import iaik.pkcs.pkcs11.Module;

public class Maini {
  
  protected static Module module;

  public static void main(String[] args) throws UnsupportedEncodingException, FileNotFoundException, IOException {
    thalesConn();
  }
  
  public static void thalesConn() {

  WorldCallbacks wcb = new WorldCallbacks();
  SecurityWorld world;
  
  try {
    world = new SecurityWorld(null, wcb, null, true);
    com.ncipher.km.nfkm.Module module = getUsableModule(world);

//    CreateSoftCard asdf = new CreateSoftCard(new CallbackExtend("pwwww"), module, false, "fityfiritty5");
//    asdf.go();
    
    SoftCard[] softCards = world.getSoftCards();
    
    for (SoftCard softCard : softCards) {
      if ("fityfiritty5".equals(softCard.getName())) {
//        softCard.erase();
        Key[] keys = softCard.listKeys();
        for (Key key : keys) {
          
        }
        break;
      }
    }
    
  } catch (NFException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  
  
    
  }
  
  public static com.ncipher.km.nfkm.Module getUsableModule(SecurityWorld world)
    throws NFException {
    com.ncipher.km.nfkm.Module modules[] = world.getModules();
    for(int m = 0; m < modules.length; ++m)
    if(modules[m].isUsable())
    return modules[m];
    throw new NFException();
    }
  

}
