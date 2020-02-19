package beautifulQuadruples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BeautifulQuadruples {

    private Logger logger = LogManager.getLogger(this.getClass());

    public int beautifulQuadruples(int a, int b, int c, int d) {
        int result = 0;
        List<Integer> tempList = Arrays.asList(a, b, c, d);
        List<String> repeatedList = new ArrayList<>();
        tempList.sort(null); //오름차순 정렬
        int W, X, Y, Z ;
        int tempW, tempX, tempY, tempZ ;
        W = tempList.get(0);
        X = tempList.get(1);
        Y = tempList.get(2);
        Z = tempList.get(3);

        for(int idxW = 1; idxW <= W; idxW++){
            for(int idxX = idxW; idxX <= X; idxX++){
                for(int idxY = idxX; idxY <= Y; idxY++){
                    for(int idxZ = idxY; idxZ <= Z; idxZ++){
                        if((idxW ^ idxX ^ idxY ^ idxZ) != 0){
                            logger.debug(idxW +" "+ idxX +" "+ idxY +" "+ idxZ);
                            tempList = Arrays.asList(idxW, idxX, idxY, idxZ);
                            tempList.sort(null);
                            repeatedList.add(String.valueOf(tempList.get(0))+" "+tempList.get(1)+" "+tempList.get(2)+" "+tempList.get(3));
                            logger.debug(String.valueOf(tempList.get(0))+" "+tempList.get(1)+" "+tempList.get(2)+" "+tempList.get(3));
                        }
                    }
                }
            }
        }

        List unityList = repeatedList.stream().distinct().collect(Collectors.toList());
        result = unityList.size();
        logger.debug("result :"+ result);
        return result;
    }
}
