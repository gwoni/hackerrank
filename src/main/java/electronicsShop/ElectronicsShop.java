package electronicsShop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.*;
import java.util.stream.Collectors;

public class ElectronicsShop {
    private Logger logger = LogManager.getLogger(this.getClass());
    private int result = -1;
    private int cost = 0;
    private int budget = 0;
    private List<Integer> listKeyboards;
    private List<Integer> listDrive;

    public int getMoneySpent(int[] keyboards, int[] drives, int b) {
        setBudget(b);
        initSortToList(keyboards, drives);
        if(isShoppable(b)) return result;
        calcResult();
        return  result;
    }

    private void setBudget(int b) {
        budget = b;
    }

    private void initSortToList(int[] keyboards, int[] drives){
        listKeyboards = Arrays.stream(keyboards).boxed().collect(Collectors.toList());
        listDrive = Arrays.stream(drives).boxed().collect(Collectors.toList());
        Collections.sort(listKeyboards, Comparator.reverseOrder());
        Collections.sort(listDrive, Comparator.reverseOrder());
    }

    private boolean isShoppable(int b){
        return (listKeyboards.get(listKeyboards.size()-1) + listDrive.get(listDrive.size()-1) > b);
    }

    private void calcResult(){
        for(int costKeyboard : listKeyboards){
            for(int costDrive : listDrive){
                cost = costDrive + costKeyboard;
                if(cost <= budget){
                    if(cost == budget){
                        result = cost;
                        break;
                    }else{
                        if(result < cost){
                            result = cost;
                        }
                    }
                }
            }
        }
    }
}
