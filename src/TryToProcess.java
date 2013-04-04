import java.util.List;
import java.util.ArrayList;

public class TryToProcess {
  public List<Double> filterSig(List<Double> arrayOfInputSig){
    int i = 0;
    List<Double> newArray = new ArrayList<>();
    double fil = 0;
    for(int j = 2, n = arrayOfInputSig.size() - 2; j < n; j++){
      fil = arrayOfInputSig.get(j-2)/3 + arrayOfInputSig.get(j-1)/2 + arrayOfInputSig.get(j)+arrayOfInputSig.get(j+1)/2 + arrayOfInputSig.get(j+2)/3;
      newArray.add(i++,fil);
    }
    return newArray;
  }
}
