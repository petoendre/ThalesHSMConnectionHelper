import com.ncipher.km.nfkm.DefaultCallBack;
import com.ncipher.nfast.NFException;

public class CallbackExtend2 extends DefaultCallBack {
  final private String password;
  
  
  public CallbackExtend2(String password) {
    super();
    this.password = password;
  }


  public String reqPPCallBack(String paramString)
    throws NFException
  {
    return password;
  }

}
